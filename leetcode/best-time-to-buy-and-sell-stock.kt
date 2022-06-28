package leetcode

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var max = 0
        prices.forEach {
            if (it < min) {
                min = it
            } else {
                max = maxOf(max, it - min)
            }
        }
        return max
    }
}
