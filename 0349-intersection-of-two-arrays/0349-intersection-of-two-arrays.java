class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        // store nums1 elements
        for (int x : nums1) {
            set1.add(x);
        }

        // check nums2 elements
        for (int x : nums2) {
            if (set1.contains(x)) {
                result.add(x);
            }
        }

        // convert set to array
        int[] ans = new int[result.size()];
        int i = 0;
        for (int x : result) {
            ans[i++] = x;
        }
        return ans;
    }
}