package leetcode

import leetcode.utils.TreeNode

class FlattenBinaryTreeToLinkedList {
    fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }

        flatten(root.left)
        flatten(root.right)

        val left = root.left
        val right = root.right

        root.left = null
        root.right = left

        if (left == null) {
            root.right = right
        } else {
            var leaf = left
            while (leaf!!.right != null) {
                leaf = leaf.right
            }
            leaf.right = right
        }
    }
}