package org.nectar.collection

import java.util.function.Consumer
import java.util.stream.Stream

data class ListTreeNode<T> @JvmOverloads constructor(
    override var data: T? = null,
    override var parent: TreeNode<T>? = null,
    override val children: Collection<TreeNode<T>?> = listOf()
) :
    AbstractTreeNode<T>(data, parent) {
    override fun addChild(child: TreeNode<T>?) {
        TODO("Not yet implemented")
    }

    override fun addChildren(children: Collection<TreeNode<T>?>?) {
        TODO("Not yet implemented")
    }

    override fun removeChild(child: TreeNode<T>?) {
        TODO("Not yet implemented")
    }

    override fun stream(): Stream<TreeNode<T>?>? {
        TODO("Not yet implemented")
    }

    override fun parallelStream(): Stream<TreeNode<T>?>? {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<TreeNode<T>?> {
        TODO("Not yet implemented")
    }

    override fun parallelWalk(action: Consumer<TreeNode<T>?>) {
        TODO("Not yet implemented")
    }

    override fun walk(action: Consumer<TreeNode<T>?>) {
        TODO("Not yet implemented")
    }
}