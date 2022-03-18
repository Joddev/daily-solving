package leetcode

class FourSum {
    class TwoInt(private val a: Int, private val b: Int) : Comparable<TwoInt> {
        override fun compareTo(other: TwoInt): Int {
            val first = a.compareTo(other.a)
            if (first == 0) {
                return b.compareTo(other.b)
            }
            return first
        }
    }

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        var prev = TwoInt(Int.MIN_VALUE, Int.MIN_VALUE)
        nums.indices.forEach { a ->
            (a + 1 until nums.size).forEach { b ->
                if (prev < TwoInt(nums[a], nums[b])) {
                    var (start, end) = (b + 1 to nums.size - 1)
                    val base = target - (nums[a] + nums[b])
                    while (start < end) {
                        val sum = nums[start] + nums[end]
                        if (sum == base) {
                            result.add(listOf(nums[a], nums[b], nums[start], nums[end]))
                            prev = TwoInt(nums[a], nums[b])
                        }
                        if (sum < base) {
                            val value = nums[start]
                            while (start < end && value == nums[start]) {
                                start++
                            }
                        } else {
                            val value = nums[end]
                            while (start < end && value == nums[end]) {
                                end--
                            }
                        }
                    }
                }
            }
        }
        return result
    }
}