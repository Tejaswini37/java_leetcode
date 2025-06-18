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
    int gcd(int x,int y){
        if(y==0) return x;
        return gcd(y,x%y);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode h1=head;
        while(head.next!=null){
            int gcd=gcd(head.val,head.next.val);
            ListNode temp=head.next;
            head.next=new ListNode(gcd,temp);
            head=temp;
        }
        return h1;
    }
}