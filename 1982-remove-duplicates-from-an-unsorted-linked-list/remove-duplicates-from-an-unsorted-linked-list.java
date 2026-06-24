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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode node = head;

        while (node != null) {
            map.put(node.val, 1 + map.getOrDefault(node.val, 0));
            node = node.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        node = pre.next;

        while (node != null) {
            if (map.get(node.val) > 1) {
                pre.next = node.next;
            } else {
                pre.next = node;
                pre = node;
            }
            node = node.next;
        }
        return dummy.next;
    }
}