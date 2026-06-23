
import org.w3c.dom.NodeList;

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

    public ListNode deleteDuplicates(ListNode head) {
        // Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node = dummy.next;
        ListNode pre = dummy;

        while (node != null) {

            if (node.next != null && node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                pre.next = node.next;
            } else {
                pre = pre.next;

            }
            node = node.next;

        }

        return dummy.next;
    }
}