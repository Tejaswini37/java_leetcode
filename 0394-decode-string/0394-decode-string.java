class Solution {
    public String decodeString(String s) {
        int num=0;
        Stack<Integer> st1=new Stack<>();
        Stack<StringBuilder> st2=new Stack<>();
        int n=0;
        StringBuilder cur=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                n*=10;
                n+=ch-'0';
            }
            else if(ch=='['){
                st1.add(n);
                n=0;
                st2.add(cur);
                cur=new StringBuilder();
            }
            else if(ch==']'){
                int times=st1.pop();
                StringBuilder prev=st2.pop();
                for(int i=0;i<times;i++){
                    prev.append(cur);
                }
                cur=prev;
            }
            else cur.append(ch);
        }
        return cur.toString();
    }
}

// class Solution {
//     private int i = 0;  // global index pointer

//     public String decodeString(String s) {
//         return dfs(s);
//     }

//     private String dfs(String s) {
//         StringBuilder curr = new StringBuilder();
//         int num = 0;

//         while (i < s.length()) {
//             char c = s.charAt(i);

//             if (Character.isDigit(c)) {
//                 num = num * 10 + (c - '0'); // build number
//                 i++;
//             } else if (c == '[') {
//                 i++; // skip '['
//                 String sub = dfs(s); // decode substring inside brackets
//                 for (int k = 0; k < num; k++) {
//                     curr.append(sub);
//                 }
//                 num = 0; // reset number
//             } else if (c == ']') {
//                 i++; // skip ']'
//                 return curr.toString(); // return to caller
//             } else {
//                 curr.append(c); // just a character
//                 i++;
//             }
//         }

//         return curr.toString();
//     }
// }
