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
    public ListNode mergeKLists(ListNode[] lists) {
        // 1 2 3
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;

        Set<Integer> nullSet = new HashSet<>();

        while (nullSet.size() < lists.length) {

            ListNode minNode = new ListNode(Integer.MAX_VALUE);
            int minIndex = -1;

            for (int i = 0; i < lists.length; i++) {
                ListNode list = lists[i];
                if (list == null) {
                    nullSet.add(i);
                    continue;
                }
                if (minNode.val > list.val) {
                    System.out.println(list.val);
                    minNode = list;
                    minIndex = i;
                }
            }

            // ListNode minNode = getMin(lists);
            if (minIndex != -1) {
                lists[minIndex] = lists[minIndex].next;
                node.next = minNode;
                node = minNode;
            }

        }
        return dummy.next;
    }
}