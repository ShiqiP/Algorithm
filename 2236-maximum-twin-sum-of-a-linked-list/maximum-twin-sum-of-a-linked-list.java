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
    public int pairSum(ListNode head) {
        // mid node of the list
        ListNode fast = head;
        ListNode slow = head;

        // 5 4 3 2 
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // reverse the list from the mid 
        ListNode node = slow;
        ListNode pre = null;
        while(node != null){
            ListNode next = node.next;
            node.next = pre;

            pre = node;
            node = next;
        }
        ListNode head2 = pre;
        int max = -1;
        // start iterate two linked list
        while(head != null && head2 != null){
            max = Math.max(head.val + head2.val, max);
            head = head.next;
            head2 = head2.next;
        }
        return max;
        // max store the max sum
    }
}