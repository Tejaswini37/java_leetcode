class Solution {
    public int minAddToMakeValid(String s) {
        int open=0, close=0;
        for(char c:s.toCharArray()){
            if(c=='(') open++;
            else{
                if(open>0) open--;
                else close++;
            }
        }
        return open+close;
    }
}

//OTHER QUESTION
// class Solution {
//     public int minReversals(String s) {
//         int n = s.length();
//         if (n % 2 != 0) return -1; // odd length can't be balanced

//         Stack<Character> st = new Stack<>();

//         for (char c : s.toCharArray()) {
//             if (c == '{') {
//                 st.push(c);
//             } else {
//                 if (!st.isEmpty() && st.peek() == '{')
//                     st.pop();
//                 else
//                     st.push(c);
//             }
//         }

//         // Count remaining '{' and '}' in stack
//         int open = 0, close = 0;
//         while (!st.isEmpty()) {
//             if (st.pop() == '{') open++;
//             else close++;
//         }

//         return (open + 1) / 2 + (close + 1) / 2;
//     }
// }
