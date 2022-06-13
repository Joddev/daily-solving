package leetcode

import leetcode.utils.TreeNode

class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
    fun buildTree(inorder: IntArray, postOrder: IntArray): TreeNode? {
        if (postOrder.isEmpty()) return null

        val root = TreeNode(postOrder.last())
        val idx = inorder.indexOf(postOrder.last())
        root.left = buildTree(inorder.sliceArray(0 until idx), postOrder.sliceArray(0 until idx))
        root.right = buildTree(inorder.sliceArray(idx + 1 until inorder.size), postOrder.sliceArray(idx until postOrder.size - 1))
        return root
    }
}