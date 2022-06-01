package leetcode

import leetcode.utils.TreeNode

class BinaryTreeInorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        return inorderTraversal(root.left) + root.`val` + inorderTraversal(root.right)
    }
}