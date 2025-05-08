class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int a[]=new int[26];
        for(int i=0;i<s1.length();i++){
            a[s1.charAt(i)-'a']--;
            a[s2.charAt(i)-'a']++;
        }int matches=0;
        for(int i=0;i<26;i++) if(a[i]==0) matches++;
        int l=0;
        for(int r=s1.length();r<s2.length();r++){
            if(matches==26) return true;
            int addidx=s2.charAt(r)-'a';
            int removeidx=s2.charAt(l)-'a';
            if(a[addidx]==0) matches--;
            a[addidx]++;
            if(a[addidx]==0) matches++;

            if(a[removeidx]==0) matches--;
            a[removeidx]--;
            if(a[removeidx]==0) matches++;
            l++;
        }
        return matches==26;
    }
}