package org.toolkit4j.standard.restful;

import java.util.ResourceBundle;

public enum I18nHttpStatusCode {
    STATUS_CODE;

    I18nHttpStatusCode(){
        ResourceBundle.getBundle("en_US.properties");
    }
}
