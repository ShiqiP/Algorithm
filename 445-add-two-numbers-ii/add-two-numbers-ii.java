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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse 
        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int value = sum % 10;
            carry = sum / 10;

            l3.next = new ListNode(value);
            l3 = l3.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            int value = sum % 10;
            carry = sum / 10;

            l3.next = new ListNode(value);
            l3 = l3.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            int value = sum % 10;
            carry = sum / 10;

            l3.next = new ListNode(value);
            l3 = l3.next;
            l2 = l2.next;
        }

        while (carry > 0) {
            int value = carry % 10;
            carry = carry / 10;
            l3.next = new ListNode(value);
            l3 = l3.next;
        }
        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;

            head.next = pre;

            pre = head;
            head = next;
        }
        return pre;
    }
}