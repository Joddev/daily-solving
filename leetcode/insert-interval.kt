package leetcode

class InsertIntervals {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val s = bs(0, intervals.size, intervals, newInterval[0], 1)
        var e = bs(0, intervals.size, intervals, newInterval[1], 0)
        if (e < intervals.size && newInterval[1] == intervals[e][0]) e++

        val pre = intervals.sliceArray(0 until s)
        val mid = intervals.sliceArray(s until e)
        val post = intervals.sliceArray(e until intervals.size)

        return pre + (arrayOf(newInterval) + mid).reduce { acc, ints ->
            merge(acc, ints)
        } + post
    }

    private fun bs(from: Int, to: Int, intervals: Array<IntArray>, target: Int, idx: Int): Int {
        if (from == to) return from

        val mid = (from + to) / 2
        val value = intervals[mid][idx]
        return if (target <= value) {
            bs(from, mid, intervals, target, idx)
        } else {
            bs(mid + 1, to, intervals, target, idx)
        }
    }

    private fun isOverlapped(a: IntArray, b: IntArray): Boolean {
        if (a[0] > b[0]) {
            return isOverlapped(b, a)
        }
        return a[1] >= b[0]
    }

    private fun merge(a: IntArray, b: IntArray): IntArray {
        if (a[0] > b[0]) {
            return merge(b, a)
        }
        return intArrayOf(a[0], maxOf(a[1], b[1]))
    }
}