package leetcode

class BestTimeToBuyAndSellStockII {
    fun maxProfit(prices: IntArray): Int {
        var prev = prices.first()
        var ret = 0
        (1 until prices.size).forEach {
            val cur = prices[it]
            if (prev < cur) {
                ret += cur - prev
                prev = cur
            } else {
                prev = cur
            }
        }
        return ret
    }
}
