package leetcode

import kotlin.math.ceil
import kotlin.math.floor

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    if (nums1.isEmpty() && nums2.isEmpty()) {
        return 0.0
    }
    if (nums1.isEmpty()) {
        return (nums2[(nums2.size - 1)/2].toDouble() + nums2[nums2.size/2]) / 2
    }
    if (nums2.isEmpty()) {
        return (nums1[(nums1.size - 1)/2].toDouble() + nums1[nums1.size/2]) / 2
    }
    val min = minOf(nums1[0], nums2[0])
    val max = maxOf(nums1[nums1.size - 1], nums2[nums2.size - 1])
    val median = findMedianBiggerSortedArraysFromRange(nums1, nums2, min, max)
    println(median)
    val total = nums1.size + nums2.size
    val biggerOfEqual = minOf(findBiggerOrEqual(median, nums1).ifNullMaxValue(), findBiggerOrEqual(median, nums2).ifNullMaxValue())
    val smaller = maxOf(findSmaller(median, nums1).ifNullMinValue(), findSmaller(median, nums2).ifNullMinValue())
    println(biggerOfEqual)
    println(smaller)
    return if (countSmaller(biggerOfEqual, nums1) + countSmaller(biggerOfEqual, nums2) == total / 2) {
        if (total % 2 == 1) {
            biggerOfEqual.toDouble()
        } else {
            (smaller.toDouble() + biggerOfEqual) / 2
        }
    } else {
        if (smaller == Int.MIN_VALUE) {
            nums1[0].toDouble()
        } else {
            smaller.toDouble()
        }
    }
}

private fun Int?.ifNullMaxValue(): Int = this ?: Int.MAX_VALUE
private fun Int?.ifNullMinValue(): Int = this ?: Int.MIN_VALUE

private fun findMedianBiggerSortedArraysFromRange(nums1: IntArray, nums2: IntArray, min: Int, max: Int): Int {
    if (min == max) {
        return min
    }
    val total = nums1.size + nums2.size
    val mid = floor((min + max) / 2.0).toInt()
    val count = countSmaller(mid, nums1) + countSmaller(mid, nums2)
    return if (count < total / 2) {
        findMedianBiggerSortedArraysFromRange(nums1, nums2, mid + 1, max)
    } else {
        findMedianBiggerSortedArraysFromRange(nums1, nums2, min, mid)
    }
}

private fun findSmaller(target: Int, nums: IntArray): Int? {
    return findSmaller(target, nums, 0, nums.size - 1)
}

private fun findSmaller(target: Int, nums: IntArray, start: Int, end: Int): Int? {
    if (start == end) {
        if (nums[start] >= target) return null
        return nums[start]
    }
    val mid = ceil((start + end) / 2.0).toInt()
    return if (nums[mid] < target) {
        findSmaller(target, nums, mid, end)
    } else {
        findSmaller(target, nums, start, mid - 1)
    }
}

private fun findBiggerOrEqual(target: Int, nums: IntArray): Int? {
    return findBiggerOrEqual(target, nums, 0, nums.size - 1)
}

private fun findBiggerOrEqual(target: Int, nums: IntArray, start: Int, end: Int): Int? {
    if (start == end) {
        if (nums[start] < target) return null
        return nums[start]
    }
    val mid = (start + end) / 2
    return if (nums[mid] < target) {
        findBiggerOrEqual(target, nums, mid + 1, end)
    } else {
        findBiggerOrEqual(target, nums, start, mid)
    }
}

private fun countSmaller(target: Int, nums: IntArray): Int {
    return countSmaller(target, nums, 0, nums.size)
}

private fun countSmaller(target: Int, nums: IntArray, start: Int, end: Int): Int {
    if (start == end) {
        return start
    }
    val mid = (start + end) / 2
    return if (target > nums[mid]) {
        countSmaller(target, nums, mid + 1, end)
    } else {
        countSmaller(target, nums, start, mid)
    }
}
