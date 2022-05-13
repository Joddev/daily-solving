package leetcode

class SortColors {
    fun sortColors(nums: IntArray): Unit {
        var zeros = 0
        var ones = 0

        nums.forEach {
            when (it) {
                0 -> zeros++
                1 -> ones++
                else -> {}
            }
        }

        nums.indices.forEach {
            if (zeros > 0) {
                zeros--
                nums[it] = 0
            } else if (ones > 0) {
                ones--
                nums[it] = 1
            } else {
                nums[it] = 2
            }
        }
    }
}