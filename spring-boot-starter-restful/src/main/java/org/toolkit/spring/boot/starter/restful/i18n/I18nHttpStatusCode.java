package org.toolkit.spring.boot.starter.restful.i18n;

import java.util.ResourceBundle;

public enum I18nHttpStatusCode {
	STATUS_CODE;

	I18nHttpStatusCode() {
		ResourceBundle.getBundle("en_US.properties");
	}
}
