/* (C)2024*/
package org.spring.boost.minio.autoconfigure.properties;

import io.minio.admin.QuotaUnit;

import java.util.Objects;
import java.util.Optional;

import lombok.*;

/**
 * MinIO 客户端配置类，用于封装与单个 MinIO 实例或租户桶相关的配置项。
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MinioClientConfig {
  /** MinIO 服务地址，例如：http://localhost:9000 */
  private String endpoint;

  /** 访问密钥（AccessKey），用于鉴权 */
  private String accessKey;

  /** 密钥（SecretKey），用于鉴权 */
  private String secretKey;

  /** 默认使用的桶名称 */
  private String bucket;

  /** 桶配额大小（与 bucketQuotaUnit 配合使用） */
  private long bucketSize = 0L;

  /** 桶配额单位，默认为 MB（需配合 bucketSize 使用） */
  private QuotaUnit bucketQuotaUnit = QuotaUnit.MB;

  /** 所属区域，MinIO 一般可选填 */
  private String region;

  /** 是否启用 admin 客户端功能（例如设置配额、用户等） */
  private boolean enableAdmin = true;

  /** 是否启用 template 操作封装（用于注入 MinioTemplate） */
  private boolean enableTemplate = true;

  /** 是否启用链路追踪（如 OpenTelemetry） */
  private boolean enableTracing = false;

  /** 是否在启动前预检查连接可用性（推荐为 true） */
  private boolean preCheckConnection = true;

  /** 是否启用双栈（DualStack）endpoint（IPv4 + IPv6） */
  private boolean enableDualStackEndpoint = true;

  /** 是否使用虚拟路径风格访问（bucket.domain.com vs domain.com/bucket） */
  private boolean enableVirtualStyleEndpoint = false;

  /** 是否对上传/下载的 stream 进行 tracing（若启用链路追踪） */
  private boolean tracingStream;

  /** 连接超时时间（单位：毫秒） */
  private long connectTimeout = 30000;

  /** 写入超时时间（单位：毫秒） */
  private long writeTimeout = 30000;

  /** 读取超时时间（单位：毫秒） */
  private long readTimeout = 30000;

  /**
   * 构造方法：仅设置基础连接信息。
   */
  public MinioClientConfig(String endpoint, String accessKey, String secretKey, String bucket) {
    this.endpoint = endpoint;
    this.accessKey = accessKey;
    this.secretKey = secretKey;
    this.bucket = bucket;
  }

  /**
   * 判断是否配置了有效的配额限制。
   * @return 若 bucketSize > 0 且单位非空，则返回 true。
   */
  public boolean isValidQuotaSetting() {
    return this.bucketSize != 0 && Objects.nonNull(bucketQuotaUnit);
  }

  public Optional<String> getRegionOptional() {
    return Optional.ofNullable(region);
  }
}
