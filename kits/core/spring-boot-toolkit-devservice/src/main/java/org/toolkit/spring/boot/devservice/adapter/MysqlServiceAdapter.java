package org.toolkit.spring.boot.devservice.adapter;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PullResponseItem;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.devservice.base.ServiceAdapter;

@Component
public class MysqlServiceAdapter implements ServiceAdapter {

	@Resource
	private DockerClient client;

	@PostConstruct
	public void init() {
		try {
			val driver = Class.forName("com.mysql.cj.jdbc.Driver");
			createService();
		} catch (ClassNotFoundException e) {
		}
	}

	@SneakyThrows
	public void createService() {
		//        CountDownLatch pullLatch = new CountDownLatch(1);
		client.pullImageCmd("mysql:latest")
				.exec(new PullImageResultCallback() {

					@Override
					public void onNext(PullResponseItem object) {
						System.out.println(object.getStatus());
					}

					@Override
					public void onComplete() {
						super.onComplete();
						System.out.println("pull finished");
						//                pullLatch.countDown();
					}
				})
				.awaitCompletion();
		//        try {
		//            pullLatch.await(); // Wait for image pull to complete
		//        } catch (InterruptedException e) {
		//            Thread.currentThread().interrupt();
		//            throw new RuntimeException("Image pull interrupted", e);
		//        }
		val container = client.createContainerCmd("mysql:latest")
				.withExposedPorts(ExposedPort.tcp(3306))
				.withEnv("MYSQL_RANDOM_ROOT_PASSWORD=true")
				.exec();
		client.startContainerCmd(container.getId()).exec();
		System.err.println(client.inspectContainerCmd(container.getId()).exec());
		System.err.println(container.getRawValues());
	}
}
