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

        ListNode tmp = prev;
        prev = null;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;
        }

        tmp = head;
        while (tmp != null && prev != null) {
            ListNode prevTmp = prev.next;
            prev.next = tmp.next;
            tmp.next = prev;
            tmp = prev.next;
            prev = prevTmp;
        }
    }
}
