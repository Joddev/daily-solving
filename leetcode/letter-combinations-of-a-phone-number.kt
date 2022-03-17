package leetcode

class LetterCombinationsOfAPhoneNumber {
    private val map = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return listOf()
        }
        return digits.fold(listOf("")) { prev, cur ->
            val target = map.getValue(cur)
            target.flatMap { c -> prev.map { str -> str + c  } }
        }
    }
}