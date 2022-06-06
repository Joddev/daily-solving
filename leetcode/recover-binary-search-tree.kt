package leetcode

import leetcode.utils.TreeNode

class RecoverBinarySearchTree {
    var first: TreeNode? = null
    var second: TreeNode? = null
    var prev: TreeNode? = null

    fun recoverTree(root: TreeNode?): Unit {
        traverse(root)

        val tmp = first!!.`val`
        first!!.`val` = second!!.`val`
        second!!.`val` = tmp
    }

    private fun traverse(root: TreeNode?) {
        if (root == null) return
        traverse(root.left)

        if (prev != null && prev!!.`val` >= root.`val`) {
            if (first == null) {
                first = prev
                second = root
            } else {
                second = root
            }
        }

        prev = root
        return traverse(root.right)
    }
}