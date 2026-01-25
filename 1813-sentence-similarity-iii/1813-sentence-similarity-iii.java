class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        int n1 = s1.length, n2 = s2.length;

        int l = 0;
        // match prefix
        while (l < n1 && l < n2 && s1[l].equals(s2[l])) {
            l++;
        }

        int r1 = n1 - 1, r2 = n2 - 1;
        // match suffix
        while (r1 >= l && r2 >= l && s1[r1].equals(s2[r2])) {
            r1--;
            r2--;
        }

        // if shorter sentence is fully matched
        return l > r1 || l > r2;
    }
}

// class Solution {
//     public boolean areSentencesSimilar(String sentence1, String sentence2) {
        
//     }
// }