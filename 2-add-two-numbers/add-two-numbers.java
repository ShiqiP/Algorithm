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
        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;
        int carry = 0;

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
            l3.next = new ListNode(carry % 10);
            l3 = l3.next;

            carry = carry / 10;
        }

        return dummy.next;
    }
}