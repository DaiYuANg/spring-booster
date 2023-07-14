package org.toolkit4j.framework.spring.boot.starter.recording.configuration;

import cn.hutool.core.util.IdUtil;
import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.toolkit4j.framework.spring.boot.starter.recording.annotation.EnableRecording;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(RecordingConfigurationProperties.class)
@EntityScan({"org.kop.framework.spring.boot.stater.recording.entities"})
public class RecordingAutoConfiguration {

	@Resource
	private LoggerConfiguration loggerConfiguration;

	@Resource
	private RecordingConfigurationProperties recordingConfigurationProperties;

	@PostConstruct
	public void init() {
		// 获取注解参数的示例代码
		Class<EnableRecording> annotatedClass = EnableRecording.class;
		val r = annotatedClass.getAnnotation(EnableRecording.class);
		System.err.println(r.packages());
	}

	@Bean
	public Gson gson() {
		return new Gson();
	}

	@Bean
	public StopWatch stopWatch() {
		return new StopWatch(IdUtil.fastSimpleUUID());
	}
}
