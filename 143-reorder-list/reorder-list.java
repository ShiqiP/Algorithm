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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode node = head;
        Deque<ListNode> stack = new ArrayDeque<>();
        // 1 2 3 4
        // 1 2 3 4 5

        // 1 2 3      4 5   
        // 1 5 2 4 3    4
        // get the second half
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }

        // insert
        while (node != null && !stack.isEmpty()) {
            ListNode next = node.next;
            ListNode peak = stack.pop();
            node.next = peak;
            peak.next = next;
            node = next;
        }
        if (node != null)
            node.next = null;
    }
}