// class Solution {
//     public int countTriples(int n) {
//         boolean[] isSquare=new boolean[n*n+1];
//         for(int i=1;i<=n;i++) isSquare[i*i]=true;
//         int count=0;
//         for(int i=1;i<n;i++){
//             for(int j=1;j<n;j++){
//                 int sum=i*i + j*j;
//                 if(sum<=n*n && isSquare[sum]) count++;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int countTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = a+1; b <= n; b++) {
                int c2 = a*a + b*b;
                int c = (int)Math.sqrt(c2);

                if (c <= n && c*c == c2) {
                    count+=2;
                }
            }
        }
        return count;
    }
}

// class Solution {
//     public int countTriples(int n) {
//         int count = 0;

//         for (int a = 1; a <= n; a++) {
//             for (int b = 1; b <= n; b++) {
//                 int c2 = a*a + b*b;
//                 int c = (int)Math.sqrt(c2);

//                 if (c <= n && c*c == c2) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }
