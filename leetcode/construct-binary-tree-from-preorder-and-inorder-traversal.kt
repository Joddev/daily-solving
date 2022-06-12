package leetcode

import leetcode.utils.TreeNode

class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) return null

        val root = TreeNode(preorder[0])
        val idx = inorder.indexOf(preorder[0])
        root.left = buildTree(preorder.sliceArray(1..idx), inorder.sliceArray(0 until idx))
        root.right = buildTree(preorder.sliceArray(idx + 1 until preorder.size), inorder.sliceArray(idx + 1 until inorder.size))
        return root
    }
}