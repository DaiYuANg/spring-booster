# Core 模块

提供项目基础设施支撑，包括通用配置、错误处理和工具类。

## 功能

- 全局异常处理
- 日志追踪拦截
- 通用工具类集合（日期、字符串、ID 生成）

## 主要类与接口

- `GlobalExceptionHandler`：统一处理控制器层异常
- `RequestIdFilter`：为每次请求生成唯一标识
- `IdGenerator`：基于 Snowflake 算法的全局 ID 生成器

## 配置示例

```yaml
spring:
  booster:
    core:
      trace:
        header-name: X-Request-Id
    snowflake:
      worker-id: 1
      datacenter-id: 1