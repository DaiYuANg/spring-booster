package org.toolkit.spring.boot.starter.minio.vo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;

@Data
@ToString
@Accessors(chain = true)
@Builder
public class PreviewVo {

    private MediaType mediaType;

    private ByteArrayResource resource;
}
