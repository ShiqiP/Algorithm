

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
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = dummy;
        ListNode pre = dummy;

        while (node != null && node.next != null) {
            node = node.next;
            if(map.get(node.val) != null){
                pre = map.get(node.val);
                pre.next = null;
                
            }else{
                pre.next = node;
                map.put(node.val, pre);
                pre = node;
            }
            
            // node = node.next;
            // map.put(node.val, 1 + map.getOrDefault(node.val, 0));
        }

        return dummy.next;
    }
}