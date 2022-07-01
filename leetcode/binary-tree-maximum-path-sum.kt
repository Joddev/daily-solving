package leetcode

import leetcode.utils.TreeNode

class BinaryTreeMaximumPathSum {
    fun maxPathSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        if (root.left == null && root.right == null) {
            return root.`val`
        }

        var ret = root.`val`
        var leftPath = 0
        var rightPath = 0
        if (root.left != null) {
            leftPath = maxOf(leftPath, maxOpenPathSum(root.left!!))
            ret = maxOf(ret, maxPathSum(root.left))
        }
        if (root.right != null) {
            rightPath = maxOf(rightPath, maxOpenPathSum(root.right!!))
            ret = maxOf(ret, maxPathSum(root.right))
        }
        ret = maxOf(ret, leftPath + root.`val` + rightPath)
        return ret
    }

    private fun maxOpenPathSum(root: TreeNode): Int {
        if (root.left == null && root.right == null) {
            return root.`val`
        }

        val left = root.left?.let { maxOpenPathSum(it) } ?: Int.MIN_VALUE
        val right = root.right?.let { maxOpenPathSum(it) } ?: Int.MIN_VALUE

        return root.`val` + maxOf(0, maxOf(left, right))
    }
}