/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        ListNode A = headA, B = headB;

        while (A != null || B != null) {
            if (A != null) {
                if (set.contains(A))
                    return A;

                set.add(A);
                A = A.next;
            }
            if (B != null) {
                if (set.contains(B))
                    return B;

                set.add(B);
                B = B.next;
            }
        }
        return null;
    }
}