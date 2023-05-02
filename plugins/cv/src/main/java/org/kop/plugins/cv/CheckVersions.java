package org.kop.plugins.cv;

import lombok.extern.slf4j.Slf4j;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

@Slf4j
public class CheckVersions implements Plugin<Project> {
    private final String taskName = "checkVersions";

    @Override
    public void apply(Project target) {
//        target.getDependencies().
        target.task(taskName).doLast(task -> {
            for (var plugin : target.getPlugins()) {
                System.err.println(plugin);
            }
            System.err.println("checked ");
        });
    }
}