package leetcode

import leetcode.utils.TreeNode

class UniqueBinarySearchTreesII {
    fun generateTrees(n: Int): List<TreeNode?> {
        return generateTrees((1..n).toList())
    }

    private fun generateTrees(values: List<Int>): List<TreeNode?> {
        if (values.isEmpty()) {
            return listOf(null)
        }

        return values.indices.flatMap { idx ->
            val left = generateTrees(values.subList(0, idx))
            val right = generateTrees(values.subList(idx + 1, values.size))

            left.flatMap { l ->
                right.map { r ->
                    val root = TreeNode(values[idx])
                    root.left = l
                    root.right = r
                    root
                }
            }
        }
    }
}