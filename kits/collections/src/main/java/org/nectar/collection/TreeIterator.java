/* (C)2023*/
package org.nectar.collection;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.nectar.collection.api.TreeNode;

@Getter
@Setter
@ToString
class TreeIterator<T> implements Iterator<TreeNode<T>> {
    private TreeNode<T> current;
    private Iterator<TreeNode<T>> childrenIterator;

    public TreeIterator(@NotNull TreeNode<T> root) {
        this.current = root;
        this.childrenIterator = root.getChildren().iterator();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public TreeNode<T> next() {
        if (current == null) {
            throw new IllegalStateException("No more elements in the tree");
        }

        TreeNode<T> nextNode = current;

        if (childrenIterator.hasNext()) {
            current = childrenIterator.next();
            childrenIterator = current.getChildren().iterator();
        } else {
            current = null;
        }

        return nextNode;
    }

    public void walk(Consumer<TreeNode<T>> action) {
        walkRecursive(current, action, false);
    }

    public void parallelWalk(Consumer<TreeNode<T>> action) {
        walkRecursive(current, action, true);
    }

    private void walkRecursive(TreeNode<T> node, @NotNull Consumer<TreeNode<T>> action, boolean parallel) {
        action.accept(node);
        if (node.getChildren().isEmpty()) return;
        Stream<TreeNode<T>> stream = parallel ? node.getChildren().parallelStream() : node.getChildren().stream();
        stream.forEach(child -> walkRecursive(child, action, parallel));
    }
}
