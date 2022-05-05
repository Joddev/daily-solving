package leetcode

class AddBinary {
    fun addBinary(a: String, b: String): String {
        return add(a.reversed(), b.reversed()).reversed()
    }

    private fun add(a: String, b: String): String {
        if (a.length < b.length) {
            return add(b, a)
        }

        var overflow = false
        val ret = a.foldIndexed("") { index, acc, c ->
            var sum = 0
            if (c == '1') sum++
            if (index < b.length && b[index] == '1') sum++
            if (overflow) sum++
            if (sum < 2) {
                overflow = false
                acc + sum
            } else {
                overflow = true
                acc + (sum % 2)
            }
        }

        return if (overflow) {
            ret + '1'
        } else {
            ret
        }
    }
}