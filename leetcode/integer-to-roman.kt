package leetcode

class IntegerToRoman {
    class RomanSet(private val ten: Char, private val five: Char, private val one: Char) {
        fun roman(num: Int): String {
            if (num == 9) return "$one$ten"
            if (num == 4) return "$one$five"
            return "$five".repeat(num / 5) + "$one".repeat(num % 5)
        }
    }
    private val ones = RomanSet('X', 'V', 'I')
    private val tens = RomanSet('C', 'L', 'X')
    private val hundreds = RomanSet('M', 'D', 'C')

    fun intToRoman(num: Int): String {
        return "M".repeat(num / 1000) +
                hundreds.roman((num % 1000) / 100) +
                tens.roman((num % 100) / 10) +
                ones.roman(num % 10)
    }
}