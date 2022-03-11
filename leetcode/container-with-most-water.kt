package leetcode

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var (max, left, right) = listOf(0, 0, height.size - 1)
        while (left < right) {
            max = maxOf(max, minOf(height[left], height[right]) * (right - left))
            if (height[left] < height[right]) {
                val prev = height[left]
                while (left < right && prev >= height[left]) {
                    left++
                }
            } else {
                val prev = height[right]
                while (left < right && prev >= height[right]) {
                    right--
                }
            }
        }
        return max
    }
}
