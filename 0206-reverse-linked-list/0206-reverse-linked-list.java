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
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode prev=null;
//         ListNode cur=head;
//         while(cur!=null){
//             ListNode next=cur.next;
//             cur.next=prev;
//             prev=cur;
//             cur=next;

//         }
//         return prev;
//     }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newhead=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newhead;
    }
}
//1..push values to stack pop values and assign value to node(just changing the nodes)

