plugins{
    java
}

dependencies{
    val picocliVersion = "4.7.5"
    implementation("info.picocli:picocli:$picocliVersion")
    implementation("info.picocli:picocli-codegen:$picocliVersion")
    implementation("info.picocli:picocli-shell-jline3:$picocliVersion")
    annotationProcessor("info.picocli:picocli-codegen:$picocliVersion")
}