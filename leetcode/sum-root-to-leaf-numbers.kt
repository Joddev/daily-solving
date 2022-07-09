package leetcode

import leetcode.utils.TreeNode

class SumRootToLeafNumbers {
    fun sumNumbers(root: TreeNode?): Int {
        return numbers(root!!).map {
            it.reduceRight { i, acc -> acc * 10 + i }
        }.sum()
    }

    private fun numbers(root: TreeNode): List<List<Int>> {
        if (root.left == null && root.right == null) return listOf(listOf(root.`val`))
        val from = mutableListOf<List<Int>>()
        if (root.left != null) from.addAll(numbers(root.left!!))
        if (root.right != null) from.addAll(numbers(root.right!!))
        return from.map { it + root.`val` }
    }
}
