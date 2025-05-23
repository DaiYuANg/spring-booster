package org.spring.boost.filesystem.stream;

import io.vavr.control.Try;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
@Getter
public class InputStreamWrapper extends InputStream {

  private final InputStream originalStream;
  private final long totalBytes;
  private long bytesRead = 0;
  private final boolean trackProgress;
  private final long startTime;
  private final byte[] cacheBuffer;  // 缓存文件数据
  private int cachePosition = 0;  // 当前缓存读取位置

  public InputStreamWrapper(
    InputStream originalStream,
    long totalBytes,
    boolean trackProgress,
    int cacheSize
  ) {
    this.originalStream = originalStream;
    this.totalBytes = totalBytes;
    this.trackProgress = trackProgress;
    this.startTime = System.currentTimeMillis();
    this.cacheBuffer = new byte[cacheSize]; // 初始化缓存
  }

  @Override
  public int read() throws IOException {
    return readBytes(1);
  }

  @Override
  public int read(byte @NotNull [] b) throws IOException {
    return readBytes(b.length);
  }

  @Override
  public int read(byte @NotNull [] b, int off, int len) throws IOException {
    return readBytes(len);
  }

  private int readBytes(int length) throws IOException {
    // 如果缓存中有数据，则直接从缓存中读取
    if (cachePosition < bytesRead) {
      int bytesToRead = (int) Math.min(length, bytesRead - cachePosition);
      System.arraycopy(cacheBuffer, cachePosition, cacheBuffer, 0, bytesToRead);
      cachePosition += bytesToRead;
      return bytesToRead;
    }

    // 如果缓存没有数据，使用原始流读取并缓存
    return Try.of(() -> {
      int bytesReadNow = originalStream.read(cacheBuffer);
      if (bytesReadNow != -1 && trackProgress) {
        updateProgress(bytesReadNow);
      }
      return bytesReadNow;
    }).getOrElseThrow(e -> {
      log.error("Error reading bytes from stream", e);
      return new IOException("Error reading bytes", e);
    });
  }

  private void updateProgress(int bytesReadNow) {
    bytesRead += bytesReadNow;
    if (trackProgress) {
      logProgress();
    }
  }

  private void logProgress() {
    val elapsedTime = System.currentTimeMillis() - startTime;
    log.info("Uploaded {}/{} bytes. Elapsed time: {} ms", bytesRead, totalBytes, elapsedTime);
  }


  public Stream<Byte> toByteStream() throws IOException {
    val buffer = new byte[1024];
    return Stream.generate(() -> {
      try {
        val bytesReadNow = read(buffer);
        if (bytesReadNow == -1) {
          return null;
        }
        return buffer[bytesReadNow - 1];
      } catch (IOException e) {
        log.error("Error converting stream to byte stream", e);
        return null;
      }
    }).takeWhile(Objects::nonNull);
  }

  @Override
  public void close() throws IOException {
    super.close();
    originalStream.close();
  }
}
