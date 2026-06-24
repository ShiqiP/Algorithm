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

        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;
        int carry = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // 7 2 4 3 
            //   5 6 4
            int value = sum % 10;
            carry = sum / 10;
            sum = carry;

            l3.next = new ListNode(value);
            l3 = l3.next;

        }
        if (carry > 0) {
            l3.next = new ListNode(carry);
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