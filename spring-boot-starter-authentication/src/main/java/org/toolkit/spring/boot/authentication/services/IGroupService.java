package org.toolkit.spring.boot.authentication.services;

import cn.hutool.core.lang.tree.Tree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.toolkit.spring.boot.authentication.entities.GroupEntity;

public interface IGroupService<E extends GroupEntity> {
	Page<E> queryPageableList(E entity, Pageable pageable);

	Tree<GroupEntity> queryGroupTree(GroupEntity entity);
}
