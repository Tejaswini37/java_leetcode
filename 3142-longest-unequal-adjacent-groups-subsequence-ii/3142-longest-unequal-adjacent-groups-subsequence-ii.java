class Solution {

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        List<String> dp[][]=new ArrayList[n+1][n];
        return memo(n,0,words,groups,dp);
    }
    List<String> memo(int prev,int cur,String words[],int groups[],List<String> dp[][]){
        if(cur>=words.length) return new ArrayList<>();
        if(dp[prev][cur]!=null) return dp[prev][cur];
        //not take
        List<String> nottake=memo(prev,cur+1,words,groups,dp);
        //take;
        List<String> take=new ArrayList<>();
        if(prev==words.length || (groups[cur]!=groups[prev] && hamming(words[cur],words[prev]))){
            take=memo(cur,cur+1,words,groups,dp);
            // clone to avoid modifying shared list
            take=new ArrayList<>(take);
            take.add(0,words[cur]);
        }
        dp[prev][cur]=take.size()>nottake.size()?take:nottake;
        return dp[prev][cur];
    }
    boolean hamming(String a,String b){
        int c=0;
        if(a.length()!=b.length()) return false;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)) c++;
            if(c>1) return false;
        }
        return true;
    }
}

//recursion
// import java.util.*;

// class Solution {
//     // Main method to get the words in the longest valid subsequence
//     public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
//         // Start recursion with no previous word selected (prev = -1) and current index 0
//         return recur(-1, 0, words, groups);
//     }

//     // Recursive helper method to build the longest valid subsequence
//     List<String> recur(int prev, int curr, String[] words, int[] groups) {
//         // Base case: If we've processed all words, return an empty list
//         if (curr >= words.length) return new ArrayList<>();

//         // Option 1: Skip the current word
//         List<String> notTakeList = recur(prev, curr + 1, words, groups);

//         // Option 2: Take the current word, if valid
//         List<String> takeList = new ArrayList<>();
//         if (prev == -1 || 
//             (groups[curr] != groups[prev] && hamming(words[curr], words[prev]) == 1)) {
//             // Recursively get the best subsequence starting from curr as the new prev
//             takeList = recur(curr, curr + 1, words, groups);
//             // Add current word to the front of the result list
//             takeList.add(0, words[curr]);
//         }

//         // Return the longer subsequence between taking and not taking the current word
//         return takeList.size() > notTakeList.size() ? takeList : notTakeList;
//     }

//     // Helper method to compute Hamming distance between two strings
//     int hamming(String a, String b) {
//         int dist = 0;
//         for (int i = 0; i < a.length(); i++) {
//             if (a.charAt(i) != b.charAt(i)) dist++;
//         }
//         return dist;
//     }
// }

// tabulation
// import java.util.*;

// class Solution {
//     public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
//         int n = words.length;
        
//         // dp[i] = longest subsequence ending at i
//         int[] dp = new int[n];
//         List<List<String>> paths = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             dp[i] = 1; // At least the word itself
//             List<String> path = new ArrayList<>();
//             path.add(words[i]);
//             paths.add(path);
//         }

//         int maxLen = 1;
//         List<String> bestPath = paths.get(0);

//         for (int i = 1; i < n; i++) {
//             for (int j = 0; j < i; j++) {
//                 if (groups[i] != groups[j] && hamming(words[i], words[j]) == 1) {
//                     if (dp[j] + 1 > dp[i]) {
//                         dp[i] = dp[j] + 1;
//                         paths.set(i, new ArrayList<>(paths.get(j)));
//                         paths.get(i).add(words[i]);
//                     }
//                 }
//             }

//             // Track best result
//             if (dp[i] > maxLen) {
//                 maxLen = dp[i];
//                 bestPath = paths.get(i);
//             }
//         }

//         return bestPath;
//     }

//     private int hamming(String a, String b) {
//         int dist = 0;
//         for (int i = 0; i < a.length(); i++) {
//             if (a.charAt(i) != b.charAt(i)) dist++;
//         }
//         return dist;
//     }
// }
