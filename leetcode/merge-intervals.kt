package leetcode

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        return intervals.fold(emptyArray()) { acc, it ->
            println(acc.joinToString("|") { it.joinToString() })
            if (acc.isEmpty()) {
                arrayOf(it)
            } else {
                val last = acc.last()
                if (isOverlapped(last, it)) {
                    acc[acc.size - 1] = join(last, it)
                    acc
                } else {
                    acc + arrayOf(it)
                }
            }
        }
    }

    private fun isOverlapped(a: IntArray, b: IntArray): Boolean {
        if (a[0] > b[0]) {
            return isOverlapped(b, a)
        }
        return a[1] >= b[0]
    }

    private fun join(a: IntArray, b: IntArray): IntArray {
        if (a[0] > b[0]) {
            return join(b, a)
        }
        return intArrayOf(a[0], maxOf(a[1], b[1]))
    }
}