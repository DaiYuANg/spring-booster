plugins{
    id("org.siouan.frontend-jdk17") version "8.0.0"
}
apply<WebJarPlugin>()

val nodeVersion = "20.9.0"

frontend{
    nodeVersion.set(nodeVersion)
}

