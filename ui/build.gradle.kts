plugins {
  //    id 'com.coditory.webjar' version "${webjarVersion}" apply(false)
  //
}
//    https://www.webjars.org/
subprojects {
  apply {
    //        plugin("com.coditory.webjar")
    plugin("com.github.node-gradle.node")
  }

  //    node {
  //        download = false
  //        distBaseUrl = "https://npmmirror.com/mirrors/node/"
  //        version = "18.16.1"
  //        nodeProjectDir = file("${project.projectDir}")
  //    }
}
