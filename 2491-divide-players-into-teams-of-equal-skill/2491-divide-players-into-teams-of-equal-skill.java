class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int n = skill.length;
        int target = skill[0] + skill[n - 1];
        long chemistry = 0;

        int l = 0, r = n - 1;

        while (l < r) {
            if (skill[l] + skill[r] != target) {
                return -1;
            }
            chemistry += (long) skill[l] * skill[r];
            l++;
            r--;
        }

        return chemistry;
    }
}

// class Solution {
//     public long dividePlayers(int[] skill) {
        
//     }
// }