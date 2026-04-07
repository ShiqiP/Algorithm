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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode before = dummy;
        
        for(int i=1; i<left; i++){
            before = before.next;
        }
        
        ListNode pre = before;
        ListNode cur = before.next;
        
        for(int i=left; i<=right; i++){
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur= nextNode;
        }
        before.next.next = cur;
        before.next = pre;
        
        return dummy.next;
    }
}