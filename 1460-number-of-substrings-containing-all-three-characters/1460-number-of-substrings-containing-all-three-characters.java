class Solution {
    public int numberOfSubstrings(String s) {
        int freq[]=new int[3];
        int left=0, res=0;
        for(int right=0; right<s.length(); right++){
            freq[s.charAt(right)- 'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                res+=(s.length()-right);
                freq[s.charAt(left)-'a']--;
                left++;
            }
        }
        return res;
    }
}

// Function to count substrings containing at least one 'a', one 'b', and one 'c'
    // public int numberOfSubstrings(String s) {
    //     // Variable to store final count
    //     int count = 0;
    //     // Length of the input string
    //     int n = s.length();

    //     // Outer loop to fix the start of the substring
    //     for (int i = 0; i < n; i++) {
    //         // Array to track the count of 'a', 'b', and 'c'
    //         int[] freq = new int[3];

    //         // Inner loop to fix the end of the substring
    //         for (int j = i; j < n; j++) {
    //             // Update frequency for current character
    //             freq[s.charAt(j) - 'a']++;

    //             // Check if all three characters are present
    //             if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
    //                 // Add valid substring
    //                 count++;
    //             }
    //         }
    //     }

    //     return count;
    // }

    // Function to count substrings containing at least one 'a', 'b', and 'c' using sliding window
    // public int numberOfSubstrings(String s) {
    //     // Frequency array for 'a', 'b', 'c'
    //     int[] freq = new int[3];

    //     // Left pointer for the sliding window
    //     int left = 0;

    //     // Result variable to store count of valid substrings
    //     int res = 0;

    //     // Traverse the string with right pointer
    //     for (int right = 0; right < s.length(); right++) {
    //         // Increment frequency of current character
    //         freq[s.charAt(right) - 'a']++;

    //         // Shrink the window from the left while all characters are present
    //         while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
    //             // Count substrings from current right to end
    //             res += (s.length() - right);

    //             // Move left pointer and update frequency
    //             freq[s.charAt(left) - 'a']--;
    //             left++;
    //         }
    //     }

    //     return res;
    // }