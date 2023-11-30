package org.toolkit.example.faker;

import static java.util.stream.IntStream.range;

import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import lombok.val;
import net.datafaker.Faker;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.toolkit.example.entity.ExampleUserEntity;
import org.toolkit.example.entity.ExampleUserGroupEntity;
import org.toolkit.example.repository.ExampleUserEntityRepository;
import org.toolkit.example.repository.ExampleUserGroupEntityRepository;
import org.toolkit.spring.boot.mapping.database.source.entity.MappingEntity;
import org.toolkit.spring.boot.mapping.database.source.repository.MappingEntityRepository;

@Component
public class FakerMappings {

	@Resource
	private MappingEntityRepository repository;

	@Resource
	private ExampleUserEntityRepository exampleUserEntityRepository;

	@Resource
	private PasswordEncoder passwordEncoder;

	@Resource
	private ExampleUserGroupEntityRepository exampleUserGroupEntityRepository;

	@EventListener(ApplicationStartedEvent.class)
	@Async
	public void init() {
		val f = new Faker();
		val entity = range(0, 20)
				.mapToObj(i -> new MappingEntity()
						.setNaming(f.name().firstName())
						.setCode(f.code().imei())
						.setIsDelete(false))
				.toList();
		repository.saveAllAndFlush(entity);
	}

	@EventListener(ApplicationStartedEvent.class)
	@Async
	@Transactional
	public void listen() {
		val faker = new Faker();
//		val groups = range(0, 1000)
//				.mapToObj(i -> new ExampleUserGroupEntity()
//						.setGroupName(faker.dog().name())
//						.setGroupDesc(faker.restaurant().description()))
//				.toList();
//		exampleUserGroupEntityRepository.saveAllAndFlush(groups);
		val a = range(0, 50)
				.mapToObj(i -> new ExampleUserEntity()
						.setPassword(faker.internet().username())
						.setPassword(faker.internet().password())
//						.setUserGroup(groups.get(RandomUtil.randomInt(0, groups.size() - 1)))
				)
				.toList();
		val test = new ExampleUserEntity().setUsername("test").setPassword(passwordEncoder.encode("test"));
		exampleUserEntityRepository.saveAndFlush(test);
		exampleUserEntityRepository.saveAllAndFlush(a);
	}
}
