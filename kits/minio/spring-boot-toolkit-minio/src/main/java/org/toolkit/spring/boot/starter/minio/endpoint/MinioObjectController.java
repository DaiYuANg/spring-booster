package org.toolkit.spring.boot.starter.minio.endpoint;

import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.toolkit.spring.boot.starter.minio.service.IMinioDownloadService;
import org.toolkit.spring.boot.starter.minio.service.IMinioPreviewService;
import org.toolkit.spring.boot.web.annotation.IgnoreResponseAdvice;

@RestController
@ConditionalOnProperty("toolkit.minio")
@RequestMapping("${toolkit.minio.preview-pattern:/minio/preview}")
@IgnoreResponseAdvice
public class MinioObjectController {
    @Resource
    private IMinioPreviewService previewService;

    @Resource
    private IMinioDownloadService minioDownloadService;

    @GetMapping("/preview/object/{clientInstance}/{bucket}/{objectId}")
    public ResponseEntity<ByteArrayResource> previewObject(
            @PathVariable String clientInstance, @PathVariable String bucket, @PathVariable String objectId) {
        val result = previewService.previewObject(clientInstance, bucket, objectId);
        return ResponseEntity
                .ok()
                .contentType(result.getMediaType())
                .body(result.getResource());
    }

    @GetMapping("/download/object/{clientInstance}/{bucket}/{objectId}/{targetName}")
    public ResponseEntity<InputStreamResource> downloadObject(
            @PathVariable String clientInstance,
            @PathVariable String bucket,
            @PathVariable String objectId,
            @PathVariable String targetName
    ) {
        val stream = minioDownloadService.downloadObject(clientInstance, bucket, objectId);
        val headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", targetName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return ResponseEntity.ok()
                .headers(headers)
                .body(stream);
    }
}
