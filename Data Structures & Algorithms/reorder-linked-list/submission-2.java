/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = slow.next;
        slow.next = null;

        ListNode curr = prev;
        prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        curr = head;
        ListNode reverse = prev;
        while (curr != null && reverse != null) {
            ListNode reverseNext = reverse.next;
            reverse.next = curr.next;
            curr.next = reverse;
            curr = reverse.next;
            reverse = reverseNext;
        }
    }
}
