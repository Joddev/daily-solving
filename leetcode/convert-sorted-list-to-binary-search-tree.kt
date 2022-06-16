package leetcode

import leetcode.utils.ListNode
import leetcode.utils.TreeNode

class ConvertSortedListToBinarySearchTree {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        if (head == null) return null
        return toBST(head, null)
    }

    private fun toBST(head: ListNode?, tail: ListNode?): TreeNode? {
        var slow = head
        var fast: ListNode? = head
        if (head == tail) return null

        while (fast != tail && fast!!.next != tail) {
            fast = fast.next!!.next
            slow = slow!!.next
        }

        val root = TreeNode(slow!!.`val`)
        root.left = toBST(head, slow)
        root.right = toBST(slow.next, tail)
        return root
    }
}