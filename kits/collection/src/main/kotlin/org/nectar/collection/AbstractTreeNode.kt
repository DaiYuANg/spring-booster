package org.nectar.collection


abstract class AbstractTreeNode<T> @JvmOverloads constructor(
    override var data: T? = null,
    override var parent: TreeNode<T>? = null
) :
    TreeNode<T> {
}