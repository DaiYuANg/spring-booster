/* (C)2023*/
package org.nectar.collection.api;

import java.util.List;
import java.util.Objects;

public interface TreeNode<T> {
	T getData();

	TreeNode<T> getParent();

	List<TreeNode<T>> getChildren();

	void setParent(TreeNode<T> parent);

	default boolean isRoot() {
		return Objects.isNull(getParent());
	}

	default boolean isLeaf() {
		return getChildren().isEmpty();
	}

	void addChild(TreeNode<T> child);

	void removeChild(TreeNode<T> child);
}
