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
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2){
                    if(o1.val > o2.val) {return 1;}
                    else if(o1.val == o2.val){return 0;}
                    else {return -1;}
                }
            }
        );
        
        for(ListNode list : lists){
            if(list != null) queue.add(list);
        }

        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            if(min.next != null) queue.add(min.next);

            node.next = min;
            node = min;

        }
        return dummy.next;
    }
}