/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        
        for (ListNode node:lists){
            if (node != null) { // pitfall
                pq.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        while (!pq.isEmpty()){
            ListNode curr = pq.poll();
            tail.next = curr;
            tail = curr;
            if (curr.next != null) {  // important
                pq.offer(curr.next);
            }
        }
        
        return dummy.next;
    }
}
