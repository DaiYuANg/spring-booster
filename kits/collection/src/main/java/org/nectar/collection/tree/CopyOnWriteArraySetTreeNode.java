/* (C)2023*/
package org.nectar.collection.tree;

import java.util.concurrent.CopyOnWriteArraySet;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.nectar.collection.api.TreeNode;

@Getter
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class CopyOnWriteArraySetTreeNode<T> extends AbstractTreeNode<T> {
	private final CopyOnWriteArraySet<TreeNode<T>> children = new CopyOnWriteArraySet<>();
}
