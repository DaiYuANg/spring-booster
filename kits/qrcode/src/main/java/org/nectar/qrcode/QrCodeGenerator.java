/* (C)2023*/
package org.nectar.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Map;

import com.google.zxing.common.BitMatrix;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;

@ToString
@EqualsAndHashCode
public class QrCodeGenerator {

    private BitMatrix matrix;

    @Builder.Default
    private final int width = 250;

    @Builder.Default
    private final int height = 250;

    public QrCodeGenerator(Map<EncodeHintType, Object> hints,
                           Path output,
                           String data,
                           int width,
                           int height
    ) {

    }


    @SneakyThrows
    public File toFile() {
        val bitMatrix = writer();
        val path = FileSystems.getDefault().getPath(output.toAbsolutePath().toString());
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return output.toFile();
    }

    public String toBase64() {
    }

    @SneakyThrows
    private BitMatrix writer() {
        return new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height, hints);
    }
}
