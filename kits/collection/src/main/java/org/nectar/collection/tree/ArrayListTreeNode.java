/* (C)2023*/
package org.nectar.collection.tree;

import java.util.ArrayList;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.nectar.collection.api.TreeNode;

@Getter
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class ArrayListTreeNode<T> extends AbstractTreeNode<T> {

	private final ArrayList<TreeNode<T>> children = new ArrayList<>();
}
