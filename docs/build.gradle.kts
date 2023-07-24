import com.github.gradle.node.npm.task.NpmTask

plugins{
    id ("com.coditory.webjar")
}

node{
    version.set("16.14.2")
}


tasks.register<NpmTask>("dev") {
    dependsOn(tasks.npmInstall)
    args.set(listOf("run","start"))
}
