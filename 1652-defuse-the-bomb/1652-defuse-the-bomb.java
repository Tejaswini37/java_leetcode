class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int res[]=new int[n];
        if(k==0) return res;
        int sum=0;
        int start,end;
        if(k>0){
            start=1;
            end=k;
        }
        else{
            start=n+k; // if n=5 k=-2 then start=5-2=3
            end=n-1;
        }
        // first window
        for(int i=start;i<=end;i++){
            sum+=code[i%n];
        }
        // next
        for(int i=0;i<n;i++){
            res[i]=sum;
            sum-=code[start%n];
            start++;
            end++;
            sum+=code[end%n];
        }
        return res;
    }
}
