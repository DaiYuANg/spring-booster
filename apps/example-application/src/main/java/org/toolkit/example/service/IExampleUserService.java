package org.toolkit.example.service;

import java.util.List;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.toolkit.example.dto.LoginDto;
import org.toolkit.example.eneity.ExampleUserEntity;
import org.toolkit.example.vo.LoginVo;

public interface IExampleUserService {
	@EventListener(ApplicationStartedEvent.class)
	@Async
	void started();

	LoginVo login(LoginDto dto);

	List<ExampleUserEntity> queryList();
}
