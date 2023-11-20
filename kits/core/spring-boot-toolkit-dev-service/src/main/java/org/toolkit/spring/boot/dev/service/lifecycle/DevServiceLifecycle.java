package org.toolkit.spring.boot.dev.service.lifecycle;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.util.ClassUtils;
import org.toolkit.spring.boot.dev.service.adapter.MysqlServiceAdapter;
import org.toolkit.spring.boot.dev.service.constant.DatabaseDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
public class DevServiceLifecycle {

    private final Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2 + 1);

    private final DockerClient client;

    public DevServiceLifecycle() {
        val config =
                DefaultDockerClientConfig.createDefaultConfigBuilder().build();
        val httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .sslConfig(config.getSSLConfig())
                .maxConnections(100)
                .connectionTimeout(Duration.ofSeconds(30))
                .responseTimeout(Duration.ofSeconds(45))
                .build();
        this.client = DockerClientImpl.getInstance(config, httpClient);
        client.pingCmd().exec();
    }

    void start() {
        val callingClassLoader = ClassUtils.class.getClassLoader();
        val existsDatabaseDrivers = Arrays.stream(DatabaseDriver.values())
                .filter(databaseDriver -> ClassUtils.isPresent(databaseDriver.getValue(), callingClassLoader))
                .toList();
        new MysqlServiceAdapter(client).createService();

//        val flowables = existsDatabaseDrivers.stream()
//                .map(driver -> Flowable.fromCallable(() -> new MysqlServiceAdapter(client)
//                                .createService())
//                        .subscribeOn(Schedulers.from(executor)))
//                .toList();
//        Flowable.merge(flowables)
//                .toList()
//                .blockingSubscribe(result -> {
////                    result.stream()
////                            .map(r -> client.startContainerCmd(r.getId()))
////                            .map(s->{
////                                s.exec();
////                            });
////                    result.forEach(x -> log.info("x;{}",x));
//                });
        ;
    }

    void stop() {

    }
}
