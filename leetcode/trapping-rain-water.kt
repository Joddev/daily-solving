package leetcode

class TrappingRainWater {
    fun trap(height: IntArray): Int {
        var done = false
        var level = 1
        var ret = 0
        while (!done) {
            done = true
            var left = false
            var stack = 0
            height.forEach {
                if (it >= level) {
                    done = false
                    left = true
                    ret += stack
                    stack = 0
                } else if (left) {
                    stack += 1
                }
            }
            level++
        }
        return ret
    }
}