/* (C)2023*/
package org.nectar.collection.tree;

import java.util.concurrent.CopyOnWriteArrayList;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.nectar.collection.api.TreeNode;

@Getter
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class CopyOnWriteArrayListTreeNode<T> extends AbstractTreeNode<T> {

	private final CopyOnWriteArrayList<TreeNode<T>> children = new CopyOnWriteArrayList<>();
}
