dependencies {
}

tasks{
    withType<Jar>{
        include("**/*.json")
    }
}