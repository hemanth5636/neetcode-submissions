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
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = List.of(lists);
        if (list.isEmpty()) return null;
        
        while (list.size() != 1) {
            List<ListNode> next = new ArrayList<>();
            int size = list.size();

            for (int i = 0; i < size; i = i + 2) {
                if (i + 1 == size) {
                    next.add(list.get(i));
                } else {
                    next.add(mergeTwoLists(list.get(i), list.get(i + 1)));
                }
            }

            list = next;
        }

        return list.get(0);
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(1);
        ListNode curr = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }

        if (a != null) curr.next = a;

        if (b != null) curr.next = b;

        return dummy.next;
    }
}
