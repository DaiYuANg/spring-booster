subprojects {
	apply {
		plugin("java-library")
	}

	//
	dependencies {
//		implementation(projects.libs.property)
		//        testImplementation("org.slf4j:slf4j-simple:${slf4jVersion}")
		//        implementation("org.slf4j:slf4j-simple:${slf4jVersion}")
	}
}

dependencies{
	api(projects.libs.helpers)
	api(projects.libs.thready)
	api(projects.libs.restful)
	api(projects.libs.cache)
}