/* (C)2023*/
package org.nectar.collection.api;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

public interface TreeNode<T> {
	T getData();

	void setData(T data);

	TreeNode<T> getParent();

	Collection<TreeNode<T>> getChildren();

	void setParent(TreeNode<T> parent);

	default boolean isRoot() {
		return Objects.isNull(getParent());
	}

	default boolean isLeaf() {
		return getChildren().isEmpty();
	}

	void addChild(TreeNode<T> child);

	void addChildren(Collection<TreeNode<T>> children);

	void removeChild(TreeNode<T> child);

	Stream<TreeNode<T>> stream();

	Stream<TreeNode<T>> parallelStream();

	void walk(@NotNull Consumer<TreeNode<T>> action);

	void parallelWalk(@NonNull Consumer<TreeNode<T>> action);

	@NotNull Iterator<TreeNode<T>> iterator();
}
