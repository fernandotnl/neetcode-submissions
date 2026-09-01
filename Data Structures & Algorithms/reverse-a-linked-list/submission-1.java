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
        Stack<Integer> stack = new Stack<Integer>();
        ListNode cur = head;
        while(cur != null) {
            stack.add(cur.val);
            cur = cur.next;
        }
        ListNode result =null;
        cur = null;
        while(!stack.isEmpty()) {
            int val = stack.pop();
            if (cur != null) {
                cur.next = new ListNode(val);
                cur = cur.next;
            } else {
                cur = new ListNode(val);
                result = cur;
            }
        }
        return result;
    }
}
