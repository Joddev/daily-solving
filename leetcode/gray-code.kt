package leetcode

import kotlin.math.pow

class GrayCode {
    fun grayCode(n: Int): List<Int> {
        if (n == 1) return listOf(0,1)

        var switch = false
        return grayCode(n - 1).flatMap {
            val next = (it + 2.0.pow(n - 1)).toInt()
            switch = !switch
            if (switch) {
                listOf(it, next)
            } else {
                listOf(next, it)
            }
        }
    }
}