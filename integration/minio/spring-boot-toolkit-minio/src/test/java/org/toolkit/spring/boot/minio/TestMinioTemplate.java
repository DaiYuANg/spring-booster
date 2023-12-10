package org.toolkit.spring.boot.minio;

import static org.junit.jupiter.api.Assertions.*;

import io.minio.MinioClient;
import java.io.File;
import java.io.FileWriter;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.tika.Tika;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;
import org.testcontainers.containers.MinIOContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.toolkit.spring.boot.minio.core.template.MinioTemplate;

@Testcontainers
public class TestMinioTemplate {
	private static final String bucket = "test";

	@Container
	private final MinIOContainer minIOContainer = new MinIOContainer("minio/minio:latest");

	@Rule
	public final TemporaryFolder temporaryFolder = new TemporaryFolder();

	private File testFile;

	private MinioClient client;

	@SneakyThrows
	@BeforeEach
	public void setup() {
		client = MinioClient.builder()
				.endpoint(minIOContainer.getS3URL())
				.credentials(minIOContainer.getUserName(), minIOContainer.getPassword())
				.build();
		temporaryFolder.create();
		testFile = temporaryFolder.newFile("test.txt");
		val writer = new FileWriter(testFile);
		writer.write("Hello, this is a test!");
		writer.close();
	}

	@Test
	public void testCreateBucket() {
		val template =
				MinioTemplate.builder().client(client).defaultBucket(bucket).build();
		assertDoesNotThrow(() -> template.createBucket(bucket));
	}

	@Test
	public void testInit() {
		assertDoesNotThrow(() -> {
			MinioTemplate.builder().client(client).defaultBucket(bucket).build();
		});
	}

	@SneakyThrows
	@Test
	public void testUpload() {
		val template =
				MinioTemplate.builder().client(client).defaultBucket(bucket).build();
		template.upload(testFile, "text", "text/plain");
		assertDoesNotThrow(() -> {
			template.stat("text");
		});
	}

	@Test
	public void testObjectDoesNotExists() {
		val template =
				MinioTemplate.builder().client(client).defaultBucket(bucket).build();
		assertFalse(template.objectExists("test"));
	}

	@Test
	public void testObjectExists() {
		val template =
				MinioTemplate.builder().client(client).defaultBucket(bucket).build();
		template.upload(testFile, "test", "text/plain");
		assertTrue(template.objectExists("test"));
	}

	@SneakyThrows
	@Test
	public void testTika() {
		val t = new Tika();
		val mine = t.detect(testFile);
		System.err.println(mine);
	}

	@AfterEach
	public void clear() {
		temporaryFolder.delete();
	}
}