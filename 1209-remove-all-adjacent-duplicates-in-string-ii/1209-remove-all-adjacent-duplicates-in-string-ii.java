class Solution {
    public String removeDuplicates(String s, int k) {
        // / stack stores character and its count
        Stack<int[]> st=new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek()[0]==ch){
                st.peek()[1]++;
                if(st.peek()[1]==k) st.pop();
            }
            else st.push(new int[]{ch,1});
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            int cur[]=st.pop();
            sb.append(String.valueOf((char)cur[0]).repeat(cur[1]));
        }
        return sb.reverse().toString();
    }
}

//         // rebuild the string
//         StringBuilder sb = new StringBuilder();
//         for (int[] pair : stack) {
//             sb.append(String.valueOf((char) pair[0]).repeat(pair[1]));
//         }

//         return sb.toString();
//     }
// }
