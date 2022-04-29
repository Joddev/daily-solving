package leetcode

import leetcode.utils.ListNode

class RotateList {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 0) return head

        var left = k
        var fast = head
        while (left > 0 && fast != null) {
            left--
            fast = fast.next
        }

        if (left > 0) {
            val size = k - left
            return rotateRight(head, k % size)
        }

        if (fast == null) {
            return head
        }

        var cur = head
        while (fast!!.next != null) {
            fast = fast.next
            cur = cur!!.next
        }

        val ret = cur!!.next
        cur.next = null
        fast.next = head
        return ret
    }
}