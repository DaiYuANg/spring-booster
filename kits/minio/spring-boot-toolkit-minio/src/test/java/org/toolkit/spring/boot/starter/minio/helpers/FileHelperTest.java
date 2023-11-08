package org.toolkit.spring.boot.starter.minio.helpers;

import static org.junit.jupiter.api.Assertions.*;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import java.nio.charset.StandardCharsets;
import lombok.val;
import org.junit.jupiter.api.Test;

class FileHelperTest {

	@Test
	void calculateFileMd5() {
		val file = FileUtil.createTempFile();
		val random = RandomUtil.randomString(999999);
		System.err.println(random);
		FileUtil.writeString(random, file, StandardCharsets.UTF_8);
		val md5 = FileHelper.calculateFileMd5(file);
		System.err.println(md5);
	}

	@Test
	void testCalculateFileMd5() {}
}
