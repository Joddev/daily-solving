package leetcode

import leetcode.utils.Node
import java.util.*

class PopulatingNextRightPointersInEachNode {
    fun connect(root: Node?): Node? {
        if (root == null) return null

        val q = LinkedList<Pair<Node, Int>>()
        q.add(root to 1)
        while (q.isNotEmpty()) {
            val (node, level) = q.removeFirst()
            val next = q.firstOrNull()
            if (next != null && next.second == level) {
                node.next = next.first
            }
            node.left?.let { q.add(it to level + 1) }
            node.right?.let { q.add(it to level + 1) }
        }
        return root
    }
}