/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = head;
        ListNode pre = dummy;

        while(node != null){
            if(node.val == val){
                pre.next = node.next;
            }else{
                pre = pre.next;
            }
            node = node.next;
        }

        return dummy.next;
    }
}