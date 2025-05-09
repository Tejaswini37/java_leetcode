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
    public ListNode rev(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    public ListNode kthnode(ListNode t,int k){
        k--;
        while(t!=null && k>0){
            k--;
            t=t.next;
        }
        return t;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevnode=null;
        
        while(temp!=null){
            ListNode kth=kthnode(temp,k);
            if(kth==null){
                if(prevnode!=null) prevnode.next=temp;
                break;
            }
            ListNode nextnode=kth.next;
            kth.next=null;
            rev(temp);
            if(head==temp) head=kth;
            else prevnode.next=kth;
            prevnode=temp;
            temp=nextnode;
        }
        return head;
    }
}