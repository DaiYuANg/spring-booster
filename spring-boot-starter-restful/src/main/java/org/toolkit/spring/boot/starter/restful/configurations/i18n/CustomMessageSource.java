package org.toolkit.spring.boot.starter.restful.configurations.i18n;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.util.ResourceUtils;

@Slf4j
public class CustomMessageSource extends AbstractMessageSource {

	@Resource
	private Environment environment;

	private final ConcurrentMap<String, Set<Map.Entry<String, String>>> store = new ConcurrentHashMap<>();

	@SneakyThrows
	@PostConstruct
	public void init() {
		val i18n = ResourceUtils.getFile("i18n");
		Arrays.stream(Objects.requireNonNull(i18n.listFiles())).forEach(this::load);
	}

	@Override
	protected MessageFormat resolveCode(String code, Locale locale) {
		environment.getProperty(code);
		return null;
	}

	@SneakyThrows
	private void load(@NotNull File r) {
		val key = r.getName().split("\\.")[1];
		val p = new Properties();
		try (FileInputStream fis = new FileInputStream(r)) {
			p.load(fis);
			store.put(
					key,
					p.entrySet().stream()
							.map(propEntry -> new AbstractMap.SimpleEntry<>(
									(String) propEntry.getKey(), (String) propEntry.getValue()))
							.collect(Collectors.toSet()));
		}
	}
}
