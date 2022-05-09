package leetcode

class SimplifyPath {
    fun simplifyPath(path: String): String {
        val ret = mutableListOf<String>()
        var acc = ""
        path.forEachIndexed { index, c ->
            if (c == '/') {
                applyPath(ret, acc)
                acc = ""
            } else {
                acc += c
            }
        }
        applyPath(ret, acc)
        return "/" + ret.joinToString("/")
    }

    private fun applyPath(ret: MutableList<String>, path: String) {
        if (path == "..") {
            if (ret.isNotEmpty()) {
                ret.removeAt(ret.size - 1)
            }
        } else if (path.isNotEmpty() && path != ".") {
            ret.add(path)
        }
    }
}