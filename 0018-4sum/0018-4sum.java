class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum=(long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum<target) k++;
                    else if(sum>target) l--;
                    else{
                        ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}

//             while(k<l){
//                 long sum=(long)nums[i]+nums[j]+nums[k]+nums[l];

//                 if(sum<target){
//                     k++;
//                 }else if(sum>target){
//                     l--;
//                 }else{
//                     ans.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
//                     k++;
//                     l--;

//                     while(k<l && nums[k]==nums[k-1]){
//                         k++;
//                     }
//                     while(k<l && nums[l]==nums[l+1]){
//                         l--;
//                     }
//                 }
//             }
//             }
//         }
//         return ans;
//     }
// }

// /*

//     Time Complexity : O(N^4), Here Four nested loop creates the time complexity. Where N is the size of the
//     array(nums).

//     Space Complexity : O(N), Hash Table(set) space.

//     Solved using Array(Four Nested Loop) + Sorting + Hash Table(set). Brute Force Approach.

//     Note : this will give TLE.

// */


// /***************************************** Approach 1 *****************************************/

// class Solution {
// public:
//     vector<vector<int>> fourSum(vector<int>& nums, int target) {
//         int n = nums.size();
//         sort(nums.begin(), nums.end());
//         set<vector<int>> set;
//         vector<vector<int>> output;
//         for(int i=0; i<n-3; i++){
//             for(int j=i+1; j<n-2; j++){
//                 for(int k=j+1; k<n-1; k++){
//                     for(int l=k+1; l<n; l++){
//                         if((long long)nums[i] + (long long)nums[j] + (long long)nums[k] + 
//                         (long long)nums[l] == target){
//                             set.insert({nums[i], nums[j], nums[k], nums[l]});
//                         }
//                     }
//                 }
//             }
//         }
//         for(auto it : set){
//             output.push_back(it);
//         }
//         return output;
//     }
// };


