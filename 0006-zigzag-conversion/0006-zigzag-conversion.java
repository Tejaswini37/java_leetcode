class Solution {
    public String convert(String s, int numRows) {
        String ans[]=new String[numRows];
        for(int i=0;i<numRows;i++){
            ans[i]="";
        }
        int i=0;
        while(i<s.length()){
            for(int idx=0;idx<numRows && i<s.length();idx++){
                ans[idx]+=s.charAt(i++);
            }
            for(int idx=numRows-2;idx>0 && i<s.length();idx--){
                ans[idx]+=s.charAt(i++);
            }
        }
        String res="";
        for(String x: ans){
            res+=x;
        }
        return res;
        
    }
}

// class Solution {
//     public String convert(String s, int numRows) {
//         //create array of string of length numRows
//         String[] zigzag = new String[numRows];

//         //Initialize with ""
//         for(int i = 0; i <  numRows; i++){
//             zigzag[i] = "";
//         }


//         int i = 0;
//         //add element of particular row to zigzag
//         while(i < s.length()){
//             for(int index = 0; index < numRows && i < s.length(); index++){
//                 zigzag[index] += s.charAt(i++);
//             }

//             for(int index = numRows - 2; index > 0 && i < s.length(); index--){
//                 zigzag[index] += s.charAt(i++);
//             }
//         }

//         String output = "";
//         for(String str : zigzag ){
//             output+=str;
//         }

//         return output;
//     }
// }