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
    public ListNode swapPairs(ListNode head) {
        // store the next head;
        // store the origin head of the sub 
        // reversed sublist
        // orginHead.next = newHeadOfSub
        // 1 -> /2 -> 3
        ListNode node = head;
        ListNode tail = null;
        ListNode newHead = null;
        final int K = 2;

        while (node != null) {
            int count = 1;

            ListNode temp = node;
            while (count < K && temp != null) {
                temp = temp.next;
                count++;
            }

            if (count == K) {
                ListNode next = temp == null ? null : temp.next;
                ListNode newHeadOfSub = reverList(node, K);
                if (tail != null)
                    tail.next = newHeadOfSub;
                if (newHead == null)
                    newHead = newHeadOfSub;

                tail = node;
                node = next;
            }
        }

        if(tail != null) tail.next = node;

        return newHead;

    }

    public ListNode reverList(ListNode head, int k) {
        ListNode pre = null;
        ListNode node = head;
        int start = 0;

        while (start < k && node != null) {
            ListNode next = node.next;

            node.next = pre;
            pre = node;
            node = next;

            start++;
        }
        return pre;
    }
}