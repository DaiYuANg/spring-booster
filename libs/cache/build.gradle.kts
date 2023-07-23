subprojects{
    dependencies{
        implementation("javax.cache:cache-api:1.1.1")
    }
}

dependencies{
    api(projects.libs.cache.cacheSimple)
    api(projects.libs.cache.cacheRedisLettuce)
}