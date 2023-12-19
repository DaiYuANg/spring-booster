package org.nectar.collection.api

interface TreeNode<T> {
    val data: T
    val parent: TreeNode<T>?
    val children: List<TreeNode<T>>

    fun isRoot(): Boolean {
        return parent == null
    }

    fun isLeaf(): Boolean {
        return children.isEmpty()
    }
}
