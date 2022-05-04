package leetcode

class ValidNumber {
    fun isNumber(s: String): Boolean {
        var first = true
        var exp = false
        var expBegin = false
        var dot = false
        s.forEachIndexed { index, it ->
            when (it) {
                '+', '-' -> {
                    if (!first && !expBegin) return false
                    if (!digitFollowed(s, index)) return false
                }
                'e', 'E' -> {
                    if (first || exp) return false
                    exp = true
                    dot = false
                }
                '.' -> {
                    if (dot || exp || !numberNear(s, index)) return false
                    dot = true
                }
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {

                }
                else -> {
                    return false
                }
            }

            if (first) {
                first = false
            }
            if (expBegin) {
                expBegin = false
            }
            if (it == 'e' || it == 'E') {
                expBegin = true
            }
        }
        if (expBegin) return false
        return true
    }

    private fun numberNear(s: String, idx: Int): Boolean {
        if (s.length == 1) return false
        if (idx == 0) {
            return s[1] in '0'..'9'
        }
        if (idx == s.length - 1) {
            return s[idx - 1] in '0'..'9'
        }
        return listOf(s[idx - 1], s[idx + 1]).any { it in '0'..'9' }
    }

    private fun digitFollowed(s: String, idx: Int): Boolean {
        if (idx == s.length - 1) return false
        return s[idx + 1] in '0'..'9' || s[idx + 1] == '.'
    }
}