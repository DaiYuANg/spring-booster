/* (C)2023*/
package org.toolkit.spring.boot.route.service;

import cn.hutool.core.lang.tree.Tree;
import java.util.List;
import org.toolkit.spring.boot.route.dto.RouteEntityDto;

public interface IRouteService {
	void addRoute(RouteEntityDto dto);

	List<Tree<String>> routeTreeList();
}
