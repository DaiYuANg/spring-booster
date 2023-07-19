package org.toolkit4J.libs.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;

@AllArgsConstructor
public enum AboutFileSystem {
    TEMPORARY_DIR(new File(java.lang.System.getProperty("java.io.tmpdir"))),

    USER_HOME(new File(java.lang.System.getProperty("user.home"))),

    JAVA_HOME(new File(java.lang.System.getProperty("user.home"))),

    JAVA_LIBRARY_PATH(new File(System.getProperty("java.library.path"))),

    PROCESS_DIR(new File(java.lang.System.getProperty("user.dir"))),

    CATALINA_BASE(new File(java.lang.System.getProperty("catalina.base"))),

    CATALINA_HOME(new File(java.lang.System.getProperty("catalina.home")));


    @Getter
    private final File value;
}
