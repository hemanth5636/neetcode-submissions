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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            if (val > 9) {
                val = val % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode nn = new ListNode(val);
            curr.next = nn;
            curr = nn;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + carry;
            if (val > 9) {
                val = val % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode nn = new ListNode(val);
            curr.next = nn;
            curr = nn;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + carry;
            if (val > 9) {
                val = val % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode nn = new ListNode(val);
            curr.next = nn;
            curr = nn;
            l2 = l2.next;
        }

        if (carry != 0) {
            ListNode nn = new ListNode(carry);
            curr.next = nn;
        }

        return dummy.next;
        
    }
}
