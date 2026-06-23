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
    public ListNode rotateRight(ListNode head, int k) {
        // find the k + 1 th index node from the end
        ListNode fast = head;
        ListNode slow = head;

        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        if (length < 2 || k == 0 || k % length == 0)
            return head;

        int times = k % length;

        // 1 2 3 4 5 null  , k = 2
        while (times > 0 && fast != null) {
            fast = fast.next;
            times--;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // rear.next = head;
        ListNode newHead = slow.next;
        ListNode newRear = slow;
        ListNode oldRear = fast;
        oldRear.next = head;
        newRear.next = null;

        // return the kth index node;
        return newHead;
    }
}