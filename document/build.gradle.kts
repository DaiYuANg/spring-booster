plugins {
  alias(libs.plugins.asciidoctor.pdf)
  alias(libs.plugins.asciidoctor.jvm)
  alias(libs.plugins.asciidoctor.epub)
  alias(libs.plugins.asciidoctor.editconfig)
//  alias(libs.plugins.asciidoctor.gem)
  idea
}

//repositories {
//  ruby {
//    gems()
//  }
//}

asciidoctorj {
  modules {
    diagram.use()
  }
}

tasks.asciidoctor {
  parallelMode = true
  languages("en", "zh")
  jvm {
    jvmArgs(
      "--add-opens",
      "java.base/sun.nio.ch=ALL-UNNAMED",
      "--add-opens",
      "java.base/java.io=ALL-UNNAMED",
    )
  }
}

tasks.build {
  dependsOn(tasks.asciidoctor)
}

idea {
  module {
    sourceDirs = project.tasks.asciidoctor.get().sourceFileTree.toMutableSet()
  }
}
