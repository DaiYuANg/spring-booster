tasks.jar {
	enabled = false
}

tasks.publish {
	enabled = false
}

subprojects {
	apply {
		plugin("java-library")
	}

	//
	dependencies {
		//        testImplementation("org.slf4j:slf4j-simple:${slf4jVersion}")
		//        implementation("org.slf4j:slf4j-simple:${slf4jVersion}")
	}
}