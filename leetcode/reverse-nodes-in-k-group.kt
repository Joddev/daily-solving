package leetcode

import leetcode.utils.ListNode

class ReverseNodesInKGroup {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val origin = ListNode(0)
        origin.next = head

        var slow: ListNode = origin
        while (true) {
            var fast: ListNode? = slow
            repeat(k) { fast = fast?.next }
            if (fast == null) return origin.next

            val first = slow.next
            repeat(k - 1) {
                val latest = slow.next
                val newbie = first!!.next!!.next
                slow.next = first.next
                slow.next!!.next = latest
                first.next = newbie
            }
            slow = first!!
        }
    }
}