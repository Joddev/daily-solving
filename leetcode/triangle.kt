package leetcode

class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        return triangle.reduceRight { now, prev ->
            now.indices.map {
                now[it] + minOf(prev[it], prev[it + 1])
            }
        }.first()
    }
}
