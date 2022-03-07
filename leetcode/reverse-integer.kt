package leetcode

class ReverseInteger {
    fun reverse(x: Int): Int {
        var cur = x
        var let = 0
        while (cur != 0) {
            if (let > Int.MAX_VALUE / 10) return 0
            if (let == Int.MAX_VALUE / 10 && cur % 10 > 7) return 0
            if (let < Int.MIN_VALUE / 10) return 0
            if (let == Int.MIN_VALUE / 10 && cur % 10 > 8) return 0
            let = let * 10 + cur % 10
            cur /= 10
        }
        return let
    }
}