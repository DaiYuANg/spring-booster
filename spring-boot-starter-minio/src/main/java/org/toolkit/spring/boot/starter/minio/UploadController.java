package org.toolkit.spring.boot.starter.minio;

import java.nio.file.Paths;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.toolkit4j.libs.helpers.ImageHelperKt;

@RestController("/io")
public class UploadController {
	@SneakyThrows
	@RequestMapping(
			value = "/simpleUpload",
			method = {RequestMethod.POST, RequestMethod.PUT})
	public String upload(@RequestParam("file") @NotNull MultipartFile file) {
		return file.getResource().getFile().getAbsolutePath();
	}

	@SneakyThrows
	@RequestMapping(
			value = "/base64Upload",
			method = {RequestMethod.POST, RequestMethod.PUT})
	public String upload(@RequestParam("file") @NotNull String file) {
		val targetPath = System.getProperty("java.io.tmpdir") + "file.png";
		ImageHelperKt.base64ToImage(file, Paths.get(System.getProperty("java.io.tmpdir")));
		// Converter.base64ToFile(file, targetPath);
		return targetPath;
	}
}
