class Solution {
    public int minSwaps(String s) {

        int balance = 0;   // current balance of brackets
        int maxImbalance = 0;

        for (char c : s.toCharArray()) {
            if (c == '[') {
                balance++;
            } else {
                balance--;
            }
            maxImbalance = Math.min(maxImbalance, balance);
        }

        // each swap fixes 2 imbalance
        return (-maxImbalance + 1) / 2;
    }
}

// class Solution {
//     public int minSwaps(String s) {

//         char[] arr = s.toCharArray();
//         int i = 0, j = arr.length - 1;
//         int ans = 0;

//         while (i < j) {
//             while (i < j && arr[i] == '[') i++;
//             while (i < j && arr[j] == ']') j--;

//             if (i < j) {
//                 // swap
//                 char temp = arr[i];
//                 arr[i] = arr[j];
//                 arr[j] = temp;

//                 ans++;
//                 i++;
//                 j--;
//             }
//         }

//         return ans;
//     }
// }
