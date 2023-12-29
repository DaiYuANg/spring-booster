/* (C)2023*/
package org.nectar.collection;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.nectar.collection.api.TreeNode;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class CopyOnWriteTreeNode<T> implements TreeNode<T>, Iterable<TreeNode<T>> {
	private final T data;

	private TreeNode<T> parent = null;

	private final CopyOnWriteArrayList<TreeNode<T>> children = new CopyOnWriteArrayList<>();

	@Override
	public void addChild(@NonNull TreeNode<T> child) {
		child.setParent(this);
		this.children.add(child);
	}

	@Override
	public void removeChild(@NonNull TreeNode<T> child) {
		child.setParent(null);
		this.children.remove(child);
	}

	@NotNull @Override
	public Iterator<TreeNode<T>> iterator() {
		return new TreeIterator<>(this);
	}

	private @NotNull Stream<TreeNode<T>> internalStream(boolean parallel) {
		Spliterator<TreeNode<T>> spliterator = Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED);
		return StreamSupport.stream(spliterator, parallel);
	}

	public Stream<TreeNode<T>> stream() {
		return internalStream(false);
	}

	public Stream<TreeNode<T>> parallelStream() {
		return internalStream(true);
	}
}
