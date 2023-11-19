package org.toolkit.spring.boot.route.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.val;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.route.converter.RouteEntityConverter;
import org.toolkit.spring.boot.route.dto.RouteEntityDto;
import org.toolkit.spring.boot.route.entity.RouteEntity;
import org.toolkit.spring.boot.route.event.RouteAddEvent;
import org.toolkit.spring.boot.route.repository.RouteEntityRepository;
import org.toolkit.spring.boot.route.service.IRouteService;

@Service
public class RouteService implements IRouteService {

	@Resource
	private RouteEntityRepository routeEntityRepository;

	@Resource
	private RouteEntityConverter routeEntityConverter;

	@Resource
	private ApplicationEventPublisher eventPublisher;

	@PostConstruct
	public void init() {
		val entity = new RouteEntity()
				.setUrl("/test")
				.setParentId(String.valueOf(0))
				.setTitle("测试")
				.setExternal(false);
		routeEntityRepository.save(entity);
		val two =
				new RouteEntity().setParentId(entity.getId()).setTitle("ces11").setUrl("test/aaa");
		val three =
				new RouteEntity().setParentId(entity.getId()).setTitle("ces12").setUrl("test/bbb");
		routeEntityRepository.save(two);
		routeEntityRepository.save(three);
	}

	@Override
	public void addRoute(RouteEntityDto dto) {
		val entity = routeEntityConverter.toEntity(dto);
		routeEntityRepository.saveAndFlush(entity);
		eventPublisher.publishEvent(new RouteAddEvent(this, entity));
	}

	@Override
	public List<Tree<String>> routeTreeList() {
		val config = new TreeNodeConfig() {
			{
				setDeep(-1);
				setIdKey("id");
				setWeightKey("sort");
				setParentIdKey("parentId");
				setNameKey("url");
			}
		};
		return TreeUtil.build(routeEntityRepository.findAll(), "0", config, ((object, treeNode) -> {
			treeNode.setId(object.getId());
			treeNode.setParentId(object.getParentId());
			treeNode.putExtra("id", object.getId());
			treeNode.putExtra("pid", object.getParentId());
			treeNode.putExtra("url", object.getUrl());
			treeNode.putExtra("sort", object.getSort());
		}));
	}
}
