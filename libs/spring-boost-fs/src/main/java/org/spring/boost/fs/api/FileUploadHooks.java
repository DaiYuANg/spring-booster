package org.spring.boost.fs.api;

import java.io.IOException;
import java.io.InputStream;

public interface FileUploadHooks {

  /**
   * 文件上传开始之前的 Hook 方法
   * 用于用户在文件上传前进行校验、权限验证等操作
   */
  void beforeUpload(String path, InputStream inputStream) throws IOException;

  /**
   * 文件上传中的 Hook 方法
   * 用于用户在文件上传过程中执行操作，如进度监控、日志记录等
   */
  void duringUpload(String path, InputStream inputStream, long bytesUploaded, long totalBytes) throws IOException;

  /**
   * 文件上传成功后的 Hook 方法
   * 用于用户在文件上传成功后执行的操作，如更新数据库、发送通知等
   */
  void afterUpload(String path, long fileSize) throws IOException;

  /**
   * 文件上传失败后的 Hook 方法
   * 用于用户在文件上传失败后执行的操作，如错误日志、回滚操作等
   */
  void onUploadFailure(String path, Exception exception) throws IOException;
}
