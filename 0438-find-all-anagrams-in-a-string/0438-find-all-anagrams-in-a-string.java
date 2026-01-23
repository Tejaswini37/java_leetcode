class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if(s.length()<p.length()) return res;
        int c=p.length();
        int l=0,r=0;
        int freq[]=new int[26];
        for(char x : p.toCharArray()){
            freq[x-'a']++;
        }

        while(r<s.length()){
            char ch=s.charAt(r);
            if(freq[ch-'a']>0) c--;
            freq[ch-'a']--;
            r++;
            if(r-l==p.length()){
                if(c==0) res.add(l);
                if(freq[s.charAt(l)-'a']>=0) c++;
                freq[s.charAt(l)-'a']++;
                l++;
            }
        }
        return res;
    }
}

