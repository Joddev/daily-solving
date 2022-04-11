package leetcode

class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        val a = num1.reversed().map { it - '0' }
        val b = num2.reversed().map { it - '0' }

        val c = Array(a.size + b.size + 1) { 0 }
        a.forEachIndexed { idx1, x ->
            b.forEachIndexed { idx2, y ->
                c[idx1 + idx2] += x * y
            }
        }

        c.forEachIndexed { index, i ->
            if (i >= 10) {
                c[index] = i % 10
                c[index + 1] += i / 10
            }
        }

        val ret = c.reversed().fold("") { acc, i ->
            if (acc.isEmpty() && i == 0) {
                acc
            } else {
                acc + i
            }
        }
        return ret.ifEmpty { "0" }
    }
}