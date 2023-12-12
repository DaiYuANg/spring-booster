/* (C)2023*/
package org.nectar.nova.core;

import java.io.File;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class ProcessorBuilder {

	private File docsRoot;

	private File styleRoot;
}
