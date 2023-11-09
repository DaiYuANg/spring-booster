package org.toolkit.spring.boot.minio.helpers;

import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.digest.DigestUtil;
import java.io.File;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FileHelper {
	public static String calculateFileMd5(String file) {
		return calculateFileMd5(new File(file));
	}

	public static String calculateFileMd5(File file) {
		return DigestUtil.md5Hex(FileUtil.readUtf8String(file));
	}
}
