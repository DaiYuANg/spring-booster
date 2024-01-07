/* (C)2024*/
package org.spring.boost.authentication.constant;

public enum AuthenticationMethod {

    /**
     * Only Jwt Verify
     */
    JWT,

    /**
     * Jwt with session storage make kick feature
     */
    JWT_WITH_SESSION,

    /**
     * http basic
     */
    BASIC
}
