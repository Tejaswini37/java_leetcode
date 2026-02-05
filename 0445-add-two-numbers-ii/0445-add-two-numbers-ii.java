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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode head=null;
        while(!s1.isEmpty() || !s2.isEmpty() || carry!=0){
            int sum=carry;
            if(!s1.isEmpty()) sum+=s1.pop();
            if(!s2.isEmpty()) sum+=s2.pop();
            ListNode node=new ListNode(sum%10);
            node.next=head;
            head=node;
            carry=sum/10;
        }
        return head;
    }
}
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         l1 = reverse(l1); // reduce space o(1)
//         l2 = reverse(l2);

//         int carry = 0;
//         ListNode dummy = new ListNode(0);
//         ListNode curr = dummy;

//         while (l1 != null || l2 != null || carry != 0) {
//             int sum = carry;

//             if (l1 != null) {
//                 sum += l1.val;
//                 l1 = l1.next;
//             }

//             if (l2 != null) {
//                 sum += l2.val;
//                 l2 = l2.next;
//             }

//             curr.next = new ListNode(sum % 10);
//             curr = curr.next;

//             carry = sum / 10;
//         }

//         return reverse(dummy.next);
//     }

//     private ListNode reverse(ListNode head) {
//         ListNode prev = null;
//         while (head != null) {
//             ListNode next = head.next;
//             head.next = prev;
//             prev = head;
//             head = next;
//         }
//         return prev;
//     }
// }
