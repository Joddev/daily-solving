package leetcode

import java.util.LinkedList

class WordLadder {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val neighbors = mutableMapOf<String, List<String>>()
        val all = if (wordList.contains(beginWord)) wordList else wordList + beginWord
        all.forEach { a -> neighbors[a] = all.filter { b -> isAdjacent(a, b) }.toList() }
        val q = LinkedList<String>()
        q.add(beginWord)
        val step = mutableMapOf(beginWord to 1)
        while (q.isNotEmpty()) {
            val now = q.removeFirst()
            val next = neighbors.getValue(now)
            val nextStep = step.getValue(now) + 1
            next.filterNot { step.containsKey(it) }.forEach {
                step[it] = nextStep
                q.add(it)
            }
        }
        return step[endWord] ?: 0
    }

    private fun isAdjacent(a: String, b: String): Boolean {
        var cnt = 0
        a.indices.forEach {
            if (a[it] != b[it]) cnt++
        }
        return cnt == 1
    }
}