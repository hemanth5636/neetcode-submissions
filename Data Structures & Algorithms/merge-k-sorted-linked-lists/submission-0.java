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
        if (lists.length == 0) return null;
        List<ListNode> list = new ArrayList<>();

        for (ListNode node : lists) {
            list.add(node);
        }

        while (list.size() > 1) {
            List<ListNode> nl = new ArrayList<>();
            int index = 0;
            while (index < list.size()) {
                ListNode a = list.get(index);
                ListNode b = index + 1 >= list.size() ? null : list.get(index + 1);
                nl.add(mergeTwo(a, b));
                index = index + 2;
            }
            list = nl;
        }

        return list.get(0);

    }

    private ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        
        while (a != null && b != null) {
            if (a.val < b.val) {
                tmp.next = a;
                a = a.next;
                tmp = tmp.next;
            } else {
                tmp.next = b;
                b = b.next;
                tmp = tmp.next;
            }
        }

        if (a != null) {
            tmp.next = a;
        }

        if (b != null) {
            tmp.next = b;
        }

        return dummy.next;
    }
}
