package org.kop.libs.io.files;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.val;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Base64;

@UtilityClass
public class Converter {

    @SneakyThrows
    public static @NotNull File base64ToFile(String base64, String target) {
        val targetFile = new File(target);
        FileUtils.writeByteArrayToFile(targetFile,
                Base64.getDecoder().decode(base64));
        return targetFile;
    }

    @SneakyThrows
    public static String fileToBase64(File target) {
        return Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(target));
    }
}
