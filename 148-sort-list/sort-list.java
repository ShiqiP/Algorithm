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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode left = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        if (pre != null)
            pre.next = null;

        ListNode sortedLeft = sortList(left);
        ListNode sortedRight = sortList(slow);

        ListNode sorted = mergeSort(sortedLeft, sortedRight);

        return sorted;
    }

    public ListNode mergeSort(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                node.next = a;
                node = node.next;
                a = a.next;
            } else {
                node.next = b;
                node = node.next;
                b = b.next;
            }
        }
        if(a != null) node.next = a;
        if(b != null) node.next = b;

        return dummy.next;
    }
    // merge sort
}