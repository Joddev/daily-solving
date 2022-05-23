package leetcode

import java.util.Stack

class LargestRectangleInHistogram {
    fun largestRectangleArea(heights: IntArray): Int {
        val left = IntArray(heights.size)
        val right = IntArray(heights.size)

        val stack = Stack<Int>()
        heights.indices.forEach {
            while (stack.isNotEmpty() && heights[stack.peek()] > heights[it]) {
                left[stack.pop()] = it - 1
            }
            stack.push(it)
        }
        while (stack.isNotEmpty()) left[stack.pop()] = heights.size - 1

        heights.indices.reversed().forEach {
            while (stack.isNotEmpty() && heights[stack.peek()] > heights[it]) {
                right[stack.pop()] = it + 1
            }
            stack.push(it)
        }
        while (stack.isNotEmpty()) right[stack.pop()] = 0

        println(left.joinToString())
        println(right.joinToString())

        var max = 0
        heights.indices.forEach {
            val cur = (left[it] - right[it] + 1) * heights[it]
            max = maxOf(max, cur)
        }
        return max
    }
}