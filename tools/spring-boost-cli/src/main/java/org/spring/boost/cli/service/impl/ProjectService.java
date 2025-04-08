/* (C)2024*/
package org.spring.boost.cli.service.impl;

import java.io.FileReader;
import java.nio.file.Path;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.maven.api.model.Model;
import org.apache.maven.model.v4.MavenStaxReader;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProjectService {

    @SneakyThrows
    public void attachProject(@NotNull Path path) {
        val model = readPom(path.toFile().getAbsolutePath());
        model.getBuild().getSourceDirectory();
    }

    private static Model readPom(String pomFilePath) throws Exception {
        FileReader reader = new FileReader(pomFilePath);
        MavenStaxReader m = new MavenStaxReader();
        return m.read(reader);
    }
}
