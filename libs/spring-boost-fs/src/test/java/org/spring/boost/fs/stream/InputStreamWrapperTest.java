package org.spring.boost.fs.stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InputStreamWrapperTest {

  @Mock
  private InputStream mockInputStream;

  private InputStreamWrapper inputStreamWrapper;
  private final long totalBytes = 100L;  // 设定总字节数为 100
  private final int cacheSize = 10; // 缓存大小 10 字节
  private final boolean trackProgress = true; // 启用进度追踪

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    inputStreamWrapper = new InputStreamWrapper(mockInputStream, totalBytes, trackProgress, cacheSize);
  }

  @Test
  void testReadBytesFromStream() throws IOException {
    // 模拟 read() 方法的行为
    when(mockInputStream.read()).thenReturn(65).thenReturn(66).thenReturn(-1);

    // 从 wrapper 中读取数据
    assertEquals(65, inputStreamWrapper.read());
    assertEquals(66, inputStreamWrapper.read());
    assertEquals(-1, inputStreamWrapper.read());

    // 验证流是否被正确调用
    verify(mockInputStream, times(3)).read();
  }

  @Test
  void testReadBytesArrayFromStream() throws IOException {
    byte[] buffer = new byte[5];

    // 模拟 read(byte[]) 方法的行为
    when(mockInputStream.read(any(byte[].class))).thenReturn(5).thenReturn(3).thenReturn(-1);

    // 从 wrapper 中读取数据
    assertEquals(5, inputStreamWrapper.read(buffer));
    assertEquals(3, inputStreamWrapper.read(buffer));
    assertEquals(-1, inputStreamWrapper.read(buffer));

    // 验证流是否被正确调用
    verify(mockInputStream, times(3)).read(any(byte[].class));
  }

  @Test
  void testProgressTracking() throws IOException {
    byte[] buffer = new byte[5];

    // 模拟流的行为，设定返回的字节数
    when(mockInputStream.read(any(byte[].class))).thenReturn(5).thenReturn(5).thenReturn(-1);

    // 启动进度追踪
    inputStreamWrapper.read(buffer); // 第一次读取
    inputStreamWrapper.read(buffer); // 第二次读取

    // 验证进度追踪方法是否被调用
    assertTrue(inputStreamWrapper.getBytesRead() > 0); // 读取了字节

    // 验证流是否被正确调用
    verify(mockInputStream, times(3)).read(any(byte[].class));
  }


  @AfterEach
  void tearDown() {
    // 清理任何资源
    try {
      if (inputStreamWrapper != null) {
        inputStreamWrapper.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}