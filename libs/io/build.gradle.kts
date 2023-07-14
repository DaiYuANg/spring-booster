val jimfsVersion = "1.2"
val minioVersion = "8.5.4"
dependencies {
	implementation(project(":libs:thready"))
	api("io.minio:minio:$minioVersion")
	api("com.squareup.okhttp3:okhttp:4.9.1")
	api("com.google.jimfs:jimfs:$jimfsVersion")
}