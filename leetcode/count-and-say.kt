package leetcode

class CountAndSay {
    fun countAndSay(n: Int): String {
        if (n == 1) return "1"
        return countAndSay(countAndSay(n - 1))
    }

    private fun countAndSay(str: String): String {
        val list = mutableListOf<Pair<Char, Int>>()
        str.forEachIndexed { idx, cur ->
            if (idx > 0 && str[idx - 1] == cur) {
                val last = list.last()
                list[list.size - 1] = last.first to last.second + 1
            } else {
                list.add(cur to 1)
            }
        }
        return list.joinToString("") { (num, count) -> "$count$num" }
    }
}
