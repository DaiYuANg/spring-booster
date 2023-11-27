package org.toolkit.example.faker;

import static java.util.stream.IntStream.range;

import jakarta.annotation.Resource;
import lombok.val;
import net.datafaker.Faker;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.mapping.database.source.entity.MappingEntity;
import org.toolkit.spring.boot.mapping.database.source.repository.MappingEntityRepository;

@Component
public class FakerMappings {

	@Resource
	private MappingEntityRepository repository;

	@EventListener(ApplicationStartedEvent.class)
	@Async
	public void init() {
		val f = new Faker();
		val entity = range(1, 20)
				.mapToObj(i -> new MappingEntity()
						.setNaming(f.funnyName().name())
						.setCode(f.code().imei())
						.setIsDelete(false))
				.toList();
		repository.saveAllAndFlush(entity);
	}
}
