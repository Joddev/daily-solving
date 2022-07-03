package leetcode

import java.util.LinkedList

class WordLadderII {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
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
        if (!step.containsKey(endWord)) {
            return emptyList()
        }
        val wordByStep = mutableMapOf<Int, MutableSet<String>>()
        step.forEach {
            if (wordByStep.containsKey(it.value)) {
                wordByStep.getValue(it.value).add(it.key)
            } else {
                wordByStep[it.value] = mutableSetOf(it.key)
            }
        }
        val q2 = LinkedList<List<String>>()
        q2.add(listOf(endWord))
        val ret = mutableListOf<List<String>>()
        while (q2.isNotEmpty()) {
            val now = q2.removeFirst()!!
            val cur = now.first()
            val curStep = step.getValue(cur)
            if (curStep == 1) {
                ret.add(now)
            } else {
                val next = neighbors.getValue(cur)
                val filter = wordByStep.getValue(curStep - 1)
                next.filter { filter.contains(it) }.forEach {
                    q2.add(listOf(it) + now)
                }
            }
        }
        return ret
    }

    private fun isAdjacent(a: String, b: String): Boolean {
        var cnt = 0
        a.indices.forEach {
            if (a[it] != b[it]) cnt++
        }
        return cnt == 1
    }
}