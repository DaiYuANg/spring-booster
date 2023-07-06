package org.kop.framework.spring.boot.starter.sms.configurations;

import lombok.Data;
import org.kop.framework.spring.boot.starter.sms.constrt.SmsProvider;

@Data
public class SmsProperties {
    private SmsProvider provider;
}
