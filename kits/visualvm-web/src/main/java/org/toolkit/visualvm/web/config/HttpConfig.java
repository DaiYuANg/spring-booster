/* (C)2023*/
package org.toolkit.visualvm.web.config;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class HttpConfig {

	private int port = 10088;
}
