package org.toolkit4J.framework.spring.starter.authentication.services.impl;

import cn.hutool.core.lang.tree.Tree;
import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.toolkit4J.framework.spring.starter.authentication.entities.GroupEntity;
import org.toolkit4J.framework.spring.starter.authentication.repos.GroupEntityRepository;
import org.toolkit4J.framework.spring.starter.authentication.services.IGroupService;

@Service
public class GroupServiceImpl implements IGroupService<GroupEntity> {

	@Resource
	private GroupEntityRepository<GroupEntity> groupRepository;

	@Override
	public Page<GroupEntity> queryPageableList(GroupEntity entity, Pageable pageable) {
		return null;
	}

	public Tree<GroupEntity> queryGroupTree(GroupEntity entity) {
		val groups = groupRepository.findAll(Example.of(entity));
		// return TreeUtil.build(groups.stream()
		// .map(g -> new TreeNode<Integer>(entity.getId().intValueExact(),
		// entity.getParentGroupId(), entity.getGroupName(), (Comparable<GroupEntity>)
		// Group::getParentGroupId))
		// .toList(), entity.getParentGroupId());
		return null;
	}
}
