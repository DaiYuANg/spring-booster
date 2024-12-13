package org.spring.boost.cli.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.aspectj.weaver.tools.cache.AsynchronousFileCacheBacking;
import org.spring.boost.cli.service.ASTService;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.component.PathSearch;
import org.springframework.shell.standard.AbstractShellComponent;

@Slf4j
@Command
@RequiredArgsConstructor
public class GenerateFromEntity extends AbstractShellComponent {

  private final PathSearch.PathSearchConfig pathSearchConfig;

  private final ASTService astService;

  @Command(
    command = "generateFromEntity",
    description = "Code Generator From Entity",
    alias = "gfe",
    group = "Generator"
  )
  public String generateFromEntity() {
    val component = new PathSearch(getTerminal(), "Enter entity package", pathSearchConfig);
    component.setResourceLoader(getResourceLoader());
    component.setTemplateExecutor(getTemplateExecutor());
    val sourceTargetContext = component.run(PathSearch.PathSearchContext.empty());
    val entityPath = sourceTargetContext.getResultValue();

    log.atInfo().log("Entity Path:{}", entityPath);
    val javaFiles = FileUtils.listFiles(
      entityPath.toFile(),
      new SuffixFileFilter(".java"),
      null
    );
    log.atInfo().log("Java Files:{}",javaFiles);
    javaFiles.parallelStream().forEach(astService::parse);
    return "Finish!";
  }
}
