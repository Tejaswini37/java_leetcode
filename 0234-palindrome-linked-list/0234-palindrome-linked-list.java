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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find the middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode secondHalf = reverse(slow);

        // 3. Compare halves
        ListNode firstHalf = head;
        ListNode check = secondHalf;
        while (check != null) {
            if (firstHalf.val != check.val) return false;
            firstHalf = firstHalf.next;
            check = check.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}


// class Solution {
//     public boolean isPalindrome(ListNode head) {
        
//     }
// }

// public boolean isPalindrome(Node head) {
//         // Create an empty stack
//         // to store values
//         Stack<Integer> st = new Stack<>();
    
//         // Initialize a temporary pointer
//         // to the head of the linked list
//         Node temp = head;
    
//         // Traverse the linked list and
//         // push values onto the stack
//         while (temp != null) {
//             // Push the data from the
//             // current node onto the stack
//             st.push(temp.data);
    
//             // Move to the next node
//             temp = temp.next;
//         }
    
//         // Reset the temporary pointer back
//         // to the head of the linked list
//         temp = head;
    
//         // Compare values by popping from the stack
//         // and checking against linked list nodes
//         while (temp != null) {
//             if (temp.data != st.peek()) {
//                 // If values don't match,
//                 // it's not a palindrome
//                 return false;
//             }
    
//             // Pop the value from the stack
//             st.pop();
    
//             // Move to the next node
//             // in the linked list
//             temp = temp.next;
//         }
    
//         // If all values match,
//         // it's a palindrome
//         return true;
//     }
