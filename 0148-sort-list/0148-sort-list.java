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
    public ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(h1!=null && h2!=null){
            if(h1.val<h2.val){
                tail.next=h1;
                h1=h1.next;
            }
            else{
                tail.next=h2;
                h2=h2.next;
            }
            tail=tail.next;
        }
        if(h1!=null) tail.next=h1;
        if(h2!=null) tail.next=h2;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        // find middle
        ListNode slow=head, fast=head,prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null; // cut the list

        //merge both halfs
        ListNode left=sortList(head);
        ListNode right=sortList(slow);
        return merge(left,right);

    }
}