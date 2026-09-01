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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode cur = null;
        ListNode previous = null;
        while(cur1!=null || cur2!=null) {
            if(cur1 != null && (cur2 == null || (cur1.val < cur2.val))) {
                cur = new ListNode(cur1.val);
                cur1 = cur1.next;
            } else {
                cur = new ListNode(cur2.val);
                cur2 = cur2.next;
            }
            if (previous != null) {
                previous.next = cur;
            } else {
                result = cur;
            }
            previous = cur;
        }
        return result;
    }
}