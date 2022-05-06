package leetcode

class TextJustification {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val ret: List<MutableList<String>> = words.fold(listOf(mutableListOf())) { acc, s ->
            val last = acc.last()
            val width = last.fold(last.size - 1) { sum, it -> sum + it.length }
            if (width + s.length + 1 <= maxWidth) {
                last.add(s)
                acc
            } else {
                acc + listOf(mutableListOf(s))
            }
        }

        return ret.mapIndexed { index, strings ->
            if (index != ret.size - 1) {
                evenJustify(strings, maxWidth)
            } else {
                leftJustify(strings, maxWidth)
            }
        }
    }

    private fun evenJustify(words: List<String>, maxWidth: Int): String {
        if (words.size == 1) {
            return words.first().padEnd(maxWidth, ' ')
        }
        var padding = maxWidth - words.fold(0) { sum, it -> sum + it.length }
        var divider = 0
        val count = words.size - 1
        while (padding >= count) {
            padding -= count
            divider++
        }
        return words.reduce { acc, s ->
            if (padding > 0) {
                padding--
                acc + " ".repeat(divider + 1) + s
            } else {
                acc + " ".repeat(divider) + s
            }
        }
    }

    private fun leftJustify(words: List<String>, maxWidth: Int): String {
        return words.joinToString(" ").padEnd(maxWidth, ' ')
    }
}