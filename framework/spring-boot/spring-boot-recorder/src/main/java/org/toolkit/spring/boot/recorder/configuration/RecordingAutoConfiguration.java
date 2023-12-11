package org.toolkit.spring.boot.recorder.configuration;

import cn.hutool.core.util.IdUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;
import org.toolkit.spring.boot.recorder.annotation.EnableRecording;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(RecordingConfigurationProperties.class)
@EntityScan({"org.kop.framework.spring.boot.stater.recording.entities"})
public class RecordingAutoConfiguration {

	//	@Resource
	//	private LoggerConfiguration loggerConfiguration;

	@Resource
	private RecordingConfigurationProperties recordingConfigurationProperties;

	@PostConstruct
	public void init() {
		Class<EnableRecording> annotatedClass = EnableRecording.class;
		//		val r = annotatedClass.getAnnotation(EnableRecording.class);
		//		System.err.println(r.packages());
	}

	@Bean
	public StopWatch stopWatch() {
		return new StopWatch(IdUtil.fastSimpleUUID());
	}
}
