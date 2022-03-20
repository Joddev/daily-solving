package leetcode

import leetcode.utils.ListNode

class RemoveNthNodeFromEndOfList {
    class EvictingQueue(private val size: Int) {
        private var index = 0
        private var count = 0
        private val array = arrayOfNulls<ListNode>(size)

        fun add(node: ListNode) {
            array[(index + count++) % size] = node
        }

        fun get(idx: Int): ListNode? {
            if (idx >= size) return null
            return array[(index + count - (size - idx)) % size]
        }

        fun isFull(): Boolean {
            return count >= size
        }
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val q = EvictingQueue(n + 1)
        var cur = head
        while (cur != null) {
            q.add(cur)
            cur = cur.next
        }

        return if (q.isFull()) {
            q.get(0)!!.next = q.get(2)
            head
        } else {
            head?.next
        }
    }
}