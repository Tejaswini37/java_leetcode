class Solution {
    public int getMappedValue(int n,int map[]){
        if(n==0) return map[0];
        int ans=0,power=1;
        while(n>0){
            ans+=map[n%10]*power;
            power*=10;
            n/=10;
        }
        return ans;
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n=nums.length;
        int arr[][]=new int[n][3];
        // [mappedValue, originalIndex, originalNumber]
        for(int i=0;i<n;i++){
            arr[i][0]=getMappedValue(nums[i],mapping);
            arr[i][1]=i;
            arr[i][2]=nums[i];
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            res[i]=arr[i][2];
        }
        return res;
    }
}
