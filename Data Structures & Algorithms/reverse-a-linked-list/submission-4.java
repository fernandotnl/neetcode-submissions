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
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode previous = null;
        while(cur!= null) {
            if (cur.next == null) {
                cur.next = previous;
                return cur;
            }
            ListNode nextCur = cur.next;
            cur.next = previous;
            previous = cur;
            cur = nextCur;
        }
        return cur;
        
    }
}
