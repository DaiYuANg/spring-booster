@file:JvmName("TreeNode")

package org.nectar.collection

import org.nectar.collection.api.TreeNode

class TreeNode<T>(override val data: T, override val parent: TreeNode<T>?, override val children: List<TreeNode<T>>) :
    TreeNode<T> {
}