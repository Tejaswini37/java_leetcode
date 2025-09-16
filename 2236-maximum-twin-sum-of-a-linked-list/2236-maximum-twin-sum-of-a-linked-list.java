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
    public ListNode reverse(ListNode head){
        ListNode cur=head, prev=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode first=head;
        ListNode second=reverse(slow);
        int maxSum=0;
        while(second!=null){
            maxSum=Math.max(maxSum,first.val+second.val);
            first=first.next;
            second=second.next;
        }
        return maxSum;
    }
}

// class Solution {
//     public int pairSum(ListNode head) {
//         ArrayList<Integer> al=new ArrayList<>();
//         ListNode temp=head;
//         while(temp!=null){
//             al.add(temp.val);
//             temp=temp.next;
//         }
//         int n=al.size(),max=0;
//         for(int i=0;i<n/2;i++){
//             max=Math.max(max,al.get(i)+al.get(n-i-1));
//         }
//         return max;
//     }
// }