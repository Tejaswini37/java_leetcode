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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int i=1;
        int first=-1, last=-1, prev=-1;
        int mind=Integer.MAX_VALUE;
        ListNode prevNode=head;
        ListNode cur=head.next;
        while(cur!=null && cur.next!=null){
            int next=cur.next.val;
            if((cur.val>prevNode.val && cur.val>next) || (cur.val<prevNode.val && cur.val<next)){
                if(first==-1) first=i;
                else mind=Math.min(mind,i-prev);
                prev=i;
                last=i;
            }
            prevNode=cur;
            cur=cur.next;
            i++;
        }
        if(first==-1 || first==last) return new int[]{-1,-1};
        return new int[]{mind,last-first};
    }
}

