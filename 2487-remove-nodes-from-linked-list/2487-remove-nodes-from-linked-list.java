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
    public ListNode removeNodes(ListNode head) {
        head=reverse(head);
        int max=head.val;
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.next.val<max){
                cur.next=cur.next.next; //remove
            }
            else{ cur=cur.next;
                max=cur.val;
            }
        }
        return reverse(head);
    }
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}

