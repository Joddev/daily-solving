package leetcode

import leetcode.utils.TreeNode

class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, null to null)
    }

    private fun isValidBST(root: TreeNode?, range: Pair<Int?, Int?>): Boolean {
        if (root == null) return true

        val (left, right) = range
        if (left != null && left >= root.`val`) return false
        if (right != null && right <= root.`val`) return false

        return isValidBST(root.left, left to if (right == null) root.`val` else minOf(right, root.`val`))
                && isValidBST(root.right, (if (left == null) root.`val` else maxOf(left, root.`val`)) to right)
    }
}