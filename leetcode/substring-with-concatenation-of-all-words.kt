package leetcode

class SubstringWithConcatenationOfAllWords {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        var idx = 0
        val groupped = words.groupBy { it }
        val idxMap = groupped.mapValues { idx++ }
        val sizeMap = groupped.entries.associate { idxMap.getValue(it.key) to it.value.size }
        val size = words[0].length
        return (0 until size).flatMap { pad ->
            val list = convert(s.substring(pad), idxMap, size)
            val indices = find(list, sizeMap)
            indices.map { pad + it * size  }
        }
    }

    private fun convert(s: String, map: Map<String, Int>, size: Int): List<Int> {
        return s.windowed(size = size, step = size).map { map[it] ?: -1 }
    }

    private fun find(list: List<Int>, sizeMap: Map<Int, Int>): List<Int> {
        val size = sizeMap.values.sum()
        if (list.size < size) return emptyList()
        val map = mutableMapOf<Int, Int>()
        val ret = mutableListOf<Int>()
        repeat(size) { map.link(list[it]) }
        if (map == sizeMap) {
            ret.add(0)
        }
        (size until list.size).forEach { idx ->
            map.link(list[idx])
            map.unlink(list[idx - size])
            if (map == sizeMap) {
                ret.add(idx - size + 1)
            }
        }
        return ret
    }

    private fun MutableMap<Int, Int>.link(key: Int) {
        if (key == -1) return
        val found = this[key]
        if (found != null) {
            this[key] = found + 1
        } else {
            this[key] = 1
        }
    }

    private fun MutableMap<Int, Int>.unlink(key: Int) {
        if (key == -1) return
        val found = this.getValue(key)
        val ret = found - 1
        if (ret == 0) {
            remove(key)
        } else {
            this[key] = ret
        }
    }
}