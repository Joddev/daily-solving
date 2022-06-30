package leetcode

class BestTimeToBuyAndSellStockIII {
    fun maxProfit(prices: IntArray): Int {
        var s1 = prices.first()
        var s2 = Int.MIN_VALUE
        var s3 = Int.MIN_VALUE
        var s4 = Int.MIN_VALUE

        (1 until prices.size).forEach {
            val now = prices[it]
            s1 = maxOf(s1, -now)
            s2 = maxOf(s2, s1 + now)
            s3 = maxOf(s3, s2 - now)
            s4 = maxOf(s4, s4 + now)
        }
        return maxOf(0, s4)
    }
}
