package leetcode

class RestoreIpAddresses {
    fun restoreIpAddresses(s: String): List<String> {
        return restoreIpAddresses(listOf(), s)
    }

    private fun restoreIpAddresses(nums: List<Int>, word: String): List<String> {
        if (nums.size == 4) {
            if (word.isEmpty()) {
                return listOf(nums.joinToString("."))
            }
            return listOf()
        }

        if (word.firstOrNull() == '0') {
            return restoreIpAddresses(nums + 0, word.substring(1))
        }

        return (1..minOf(3, word.length)).mapNotNull {
            val num = word.substring(0, it).toInt()
            if (num > 255) {
                null
            } else {
                restoreIpAddresses(nums + num, word.substring(it))
            }
        }.flatten()
    }
}