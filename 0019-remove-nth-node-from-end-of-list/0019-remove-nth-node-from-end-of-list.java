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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null) return null;
        int c=0;
        ListNode t=head;
        while(t!=null){
            c++;
            t=t.next;
        }
        int k=c-n;
        if(k==0) return head.next;
        ListNode temp=head;
        ListNode prev=null;
        while(k-->0){
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
        return head;

    }
}