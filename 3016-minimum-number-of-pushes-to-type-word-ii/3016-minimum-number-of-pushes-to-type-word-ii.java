class Solution {
    public int minimumPushes(String word) {
        int freq[]=new int[26];
        for(char c : word.toCharArray()) freq[c-'a']++;
        Arrays.sort(freq);
        int pushes=0,cost=1,used=0;
        for(int i=25;i>=0;i--){
            if(freq[i]==0) return pushes;
            pushes+=freq[i]*cost;
            used++;
            if(used==8){
                cost++;
                used=0;
            }
        }
        return pushes;
    }
}

// 8 letters → cost 1
// next 8 letters → cost 2
// next 8 letters → cost 3
// remaining 2 letters → cost 4
// Total = 26 letters.