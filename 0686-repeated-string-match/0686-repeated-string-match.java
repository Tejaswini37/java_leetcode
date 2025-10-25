class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int c=0;
        while(sb.length()<b.length()){
            sb.append(a);
            c++;
        }
        if(sb.indexOf(b)!=-1) return c;
        // try one more for alignment issues
        sb.append(a);
        c++;
        if(sb.indexOf(b)!=-1) return c;
        return -1;
    }
}
// class Solution {
//     public int repeatedStringMatch(String a, String b) {
//         StringBuilder sb = new StringBuilder();
//         int count = 0;

//         // Repeat until length is at least b.length()
//         while (sb.length() < b.length()) {
//             sb.append(a);
//             count++;
//         }

//         // Check if b is now a substring
//         if (sb.indexOf(b) != -1) {
//             return count;
//         }

//         // Try one more repetition (for alignment issues)
//         sb.append(a);
//         count++;

//         if (sb.indexOf(b) != -1) {
//             return count;
//         }

//         return -1;
//     }
// }

