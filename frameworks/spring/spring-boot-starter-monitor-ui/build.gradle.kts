import com.github.gradle.node.npm.task.NpmTask

plugins{
  id ("com.coditory.webjar")
}

tasks.register<NpmTask>("dev") {
  args.set(listOf("run","dev"))
}
