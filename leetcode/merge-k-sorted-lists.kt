package leetcode

import leetcode.utils.ListNode
import java.util.PriorityQueue

class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val q = PriorityQueue<Pair<Int, ListNode>> { o1, o2 -> o1.second.`val`.compareTo(o2.second.`val`) }
        val head = ListNode(0)
        var cur = head
        for (i in lists.indices) {
            val node = lists[i]
            if (node != null) {
                q.add(i to node)
                lists[i] = node.next
            }
        }
        while (q.isNotEmpty()) {
            val (idx, polled) = q.poll()
            cur.next = polled
            cur = cur.next!!
            val node = lists[idx]
            if (node != null) {
                q.add(idx to node)
                lists[idx] = node.next
            }
        }
        return head.next
    }
}