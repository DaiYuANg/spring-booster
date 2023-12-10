package org.toolkit.spring.boot.minio.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.toolkit.spring.boot.minio.params.Base64UploadParam;
import org.toolkit.spring.boot.minio.vo.UploadResultVo;

@Slf4j
@RestController
@RequestMapping("${spring.minio.context:/minio}")
public class MinioUploadController {
	@Value("${spring.minio.context:/minio}")
	private String controllerPrefix;

	@RequestMapping(
			value = "${toolkit.minio.context:/minio}/upload",
			method = {RequestMethod.POST, RequestMethod.PUT})
	@ResponseBody
	public UploadResultVo upload(
			@RequestParam("file") MultipartFile file,
			@RequestParam(value = "anonymousAccess", required = false, defaultValue = "false") boolean anonymous) {
		return new UploadResultVo(null);
	}

	@RequestMapping(
			value = "/uploadBase64",
			method = {RequestMethod.POST, RequestMethod.PUT})
	public UploadResultVo uploadBase64(@RequestBody @NotNull Base64UploadParam param) {
		return new UploadResultVo(null);
	}
}
