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
        ListNode dummy=new ListNode();
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode temp=dummy;
        for(ListNode l: lists){
            if(l!=null){
                pq.add(l);
            }
        }
        while(!pq.isEmpty()){
            temp.next=pq.poll();
            temp=temp.next;
            if(temp.next!=null) pq.add(temp.next);
        }
        return dummy.next;
    }
}