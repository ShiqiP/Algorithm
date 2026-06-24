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
    public ListNode deleteMiddle(ListNode head) {
        // mid - 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head, slow = head, preSlow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }
        // slow is the mid
        preSlow.next = slow != null ? slow.next : null;
        return dummy.next;
    }
}