package org.toolkit.spring.boot.authentication.services.impl;

import cn.hutool.core.lang.tree.Tree;
import jakarta.annotation.Resource;
import java.math.BigInteger;
import lombok.val;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.authentication.entities.GroupEntity;
import org.toolkit.spring.boot.authentication.entities.UserGroupEntity;
import org.toolkit.spring.boot.authentication.repos.GroupEntityRepository;
import org.toolkit.spring.boot.authentication.services.IGroupService;
import org.toolkit.spring.boot.authentication.services.IUserGroupService;

@Service
public class GroupServiceImpl implements IGroupService<GroupEntity> {

	@Resource
	private GroupEntityRepository<GroupEntity> groupRepository;

	@Resource
	private IUserGroupService<UserGroupEntity> userGroupService;

	public BigInteger addGroup(GroupEntity groupEntity) {
		val saved = groupRepository.saveAndFlush(groupEntity);
		return saved.getId();
	}

	public void removeGroup(BigInteger groupId) {
		userGroupService.findByGroupId(groupId);
	}

	@Override
	public Page<GroupEntity> queryPageableList(GroupEntity entity, Pageable pageable) {
		return null;
	}

	@Override
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
