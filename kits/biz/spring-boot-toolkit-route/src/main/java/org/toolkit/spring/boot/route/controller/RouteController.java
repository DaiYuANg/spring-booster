package org.toolkit.spring.boot.route.controller;

import cn.hutool.core.lang.tree.Tree;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toolkit.spring.boot.route.service.IRouteService;

@RestController
@Slf4j
@RequestMapping("/toolkit/route")
public class RouteController {

	@Resource
	private IRouteService routeService;

	@PostConstruct
	public void init(){
		log.info("router controller");
	}

	@PostMapping("/route")
	public List<Tree<String>> treeList() {
		return routeService.routeTreeList();
	}

	@RequestMapping("/add")
	public String add() {
		return "OK";
	}
}
