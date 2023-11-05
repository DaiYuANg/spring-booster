package org.toolkit.spring.boot.starter.minio.endpoint;

import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.toolkit.spring.boot.starter.minio.service.IMinioPreviewService;

@RestController
@RequestMapping("${toolkit.minio.preview-pattern:/minio/preview}")
public class MinioPreviewController {

    @Resource
    private IMinioPreviewService previewService;

    @GetMapping("/{clientInstance}/{bucket}/{objectId}")
    public ResponseEntity<ByteArrayResource> previewImage(
            @PathVariable String clientInstance, @PathVariable String bucket, @PathVariable String objectId) {
        val result = previewService.previewObject(clientInstance, bucket, objectId);
        return ResponseEntity
                .ok()
                .contentType(result.getMediaType())
                .body(result.getResource());
    }
}
