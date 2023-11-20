plugins{
    java
}

dependencies{
    val queryDslVersion:String by project
    implementation("com.querydsl:querydsl-sql:${queryDslVersion}")
//    compile "com.querydsl:querydsl-sql:${queryDslVersion}"
    annotationProcessor("com.querydsl:querydsl-apt:${queryDslVersion}:general")
}