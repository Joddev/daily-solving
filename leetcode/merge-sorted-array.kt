package leetcode

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = 0
        var j = 0
        var cur = 0
        (0 until m).reversed().forEach {
            nums1[it + n] = nums1[it]
        }
        while (i < m && j < n) {
            if (nums1[i + n] < nums2[j]) {
                nums1[cur++] = nums1[i++ + n]
            } else {
                nums1[cur++] = nums2[j++]
            }
        }
        while (i < m) nums1[cur++] = nums1[i++ + n]
        while (j < n) nums1[cur++] = nums2[j++]
    }
}