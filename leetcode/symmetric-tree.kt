package leetcode

import leetcode.utils.TreeNode

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return isMirror(root.left, root.right)
    }

    private fun isMirror(a: TreeNode?, b: TreeNode?): Boolean {
        if (a == null || b == null) return a == b
        if (a.`val` != b.`val`) return false

        return isMirror(a.left, b.right) && isMirror(a.right, b.left)
    }
}