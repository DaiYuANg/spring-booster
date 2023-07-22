package org.toolkit4j.framework.spring.starter.monitor.docker;

//import com.github.dockerjava.api.DockerClient;
//import com.github.dockerjava.api.command.PullImageResultCallback;
//import com.github.dockerjava.api.model.PullResponseItem;
//import com.github.dockerjava.api.model.ResponseItem;
//import com.github.dockerjava.core.DefaultDockerClientConfig;
//import com.github.dockerjava.core.DockerClientImpl;
//import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Getter
public class DockerConnector {

//	private final DockerClient dockerClient;
//
//	public DockerConnector() {
//		val config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
//		val httpClient = new ApacheDockerHttpClient.Builder()
//				.dockerHost(config.getDockerHost())
//				.sslConfig(config.getSSLConfig())
//				.maxConnections(100)
//				.connectionTimeout(Duration.ofSeconds(30))
//				.responseTimeout(Duration.ofSeconds(45))
//				.build();
//		dockerClient = DockerClientImpl.getInstance(config, httpClient);
//	}
//
//	@SneakyThrows
//	public void pull(String image, boolean async) {
//		try (val pull = dockerClient.pullImageCmd(image).exec(new PullImageResultCallback() {
//			@Override
//			public void onNext(PullResponseItem item) {
//				val detail = item.getProgressDetail();
//				if (Objects.isNull(detail)
//						|| Objects.isNull(detail.getTotal())
//						|| detail.getTotal() <= 0
//						|| Objects.isNull(detail.getCurrent())) {
//					return;
//				}
//				int percentage = (int) ((detail.getCurrent() * 100) / detail.getTotal());
//				log.info("Pull :{} ,progress: {}%", image, percentage);
//			}
//
//			@Override
//			public void onStart(Closeable stream) {
//				log.info("start pull:{}", image);
//			}
//
//			@Override
//			public void onComplete() {
//				log.info("finish for pull:{}", image);
//			}
//		})) {
//			if (async) pull.awaitCompletion();
//		}
//	}
//
//	public void pull(String image) {
//		pull(image, true);
//	}
//
//	public void run() {
//		// dockerClient.createContainerCmd("mysql:latest").withport.exec();
//	}
//
//	void handleProgress(ResponseItem.ProgressDetail progressDetail) {}
//
//	@SneakyThrows
//	@PreDestroy
//	public void shutdownHook() {
//		log.info("dev service docker client close");
//		dockerClient.close();
//	}
}
