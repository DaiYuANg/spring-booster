/* (C)2023*/
package org.nectar.collection.tree;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;
import org.nectar.collection.api.TreeNode;

@Setter
@RequiredArgsConstructor
@Getter
@ToString
@SuperBuilder(toBuilder = true)
public abstract class AbstractTreeNode<T> implements TreeNode<T> {

	private T data;

	private TreeNode<T> parent;

	@Override
	public void addChild(@NonNull TreeNode<T> child) {
		child.setParent(this);
		this.getChildren().add(child);
	}

	@Override
	public void addChildren(Collection<TreeNode<T>> children) {
		this.getChildren().addAll(children);
	}

	@Override
	public void removeChild(@NonNull TreeNode<T> child) {
		child.setParent(null);
		this.getChildren().remove(child);
	}

	@Override
	public void walk(@NonNull Consumer<TreeNode<T>> action) {
		walkRecursive(this, action, false);
	}

	@Override
	public void parallelWalk(@NonNull Consumer<TreeNode<T>> action) {
		walkRecursive(this, action, true);
	}

	private void walkRecursive(TreeNode<T> node, @NotNull Consumer<TreeNode<T>> action, boolean parallel) {
		action.accept(node);
		if (node.getChildren().isEmpty()) return;
		Stream<TreeNode<T>> stream = parallel ? node.getChildren().parallelStream() : node.getChildren().stream();
		stream.forEach(child -> walkRecursive(child, action, parallel));
	}

	@NotNull @Override
	public Iterator<TreeNode<T>> iterator() {
		return new TreeIterator<>(this);
	}

	private @NotNull Stream<TreeNode<T>> internalStream(boolean parallel) {
		Spliterator<TreeNode<T>> spliterator = Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED);
		return StreamSupport.stream(spliterator, parallel);
	}

	@Override
	public Stream<TreeNode<T>> stream() {
		return internalStream(false);
	}

	@Override
	public Stream<TreeNode<T>> parallelStream() {
		return internalStream(true);
	}
}
