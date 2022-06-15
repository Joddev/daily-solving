package leetcode

import leetcode.utils.TreeNode

class ConvertSortedArrayToBinarySearchTree {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        val mid = nums.size / 2
        val root = TreeNode(nums[mid])
        root.left = sortedArrayToBST(nums.sliceArray(0 until mid))
        root.right = sortedArrayToBST(nums.sliceArray(mid + 1 until nums.size))
        return root
    }
}