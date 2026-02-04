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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i=0;
        ListNode m1=list1;
        // move to node at index a-1
        while(i<a-1){
            m1=m1.next;
            i++;
        }
         // move to node at index b
        ListNode m2=m1.next;
        while(i<b){
            m2=m2.next;
            i++;
        }
        // m2=m2.next;
        m1.next=list2;
        while(list2.next!=null) list2=list2.next;
        list2.next=m2;
        return list1;
    }
}
// class Solution {
//     public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
//         ListNode prevA = list1;
//         for (int i = 0; i < a - 1; i++) {
//             prevA = prevA.next;
//         }

//         ListNode afterB = prevA;
//         for (int i = a; i <= b; i++) {
//             afterB = afterB.next;
//         }
//         afterB = afterB.next;

//         prevA.next = list2;

//         ListNode tail = list2;
//         while (tail.next != null) {
//             tail = tail.next;
//         }

//         tail.next = afterB;

//         return list1;
//     }
// }
