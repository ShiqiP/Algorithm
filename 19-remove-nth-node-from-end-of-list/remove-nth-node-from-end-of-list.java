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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        if (head == null)
            return head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        // k + 1 th node
        // 1 2 3 4 5 , k = 6;
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}