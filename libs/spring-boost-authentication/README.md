# spring booster authentication

## 功能集合
### 自动注入 PasswordEncoder
在没有默认 password encoder时 会按照顺序注册
```java
@Bean
@ConditionalOnMissingBean(PasswordEncoder.class)
public BCryptPasswordEncoder bCryptPasswordEncoder() {
  return new BCryptPasswordEncoder();
}
```
### 注解方式生明过滤器
```java
@AuthenticationBeforeFilter(XXX.class)
class AuthenticationBeforeFilter{
  //过滤器
}
```

