/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int peak(MountainArray mountainArr){
        int l=1;
        int r=mountainArr.length()-2;
        while(l<=r){
            int m=(r-l)/2+l;
            int midVal=mountainArr.get(m);
            int midleft=mountainArr.get(m-1);
            int midright=mountainArr.get(m+1);
            if(midVal>midleft && midVal>midright){
                return m;

            }
            else if(midVal<midright) l=m+1;
            else r=m-1;
        }
        return -1;
    }
    public int bs(MountainArray a,int l,int r,int target,boolean isAsc){
        while(l<=r){
            int m=l+(r-l)/2;
            if(a.get(m)==target) return m;
            else if(a.get(m)<target){
                if(isAsc) l=m+1;
                else r=m-1;
            }
            else{
                if(isAsc) r=m-1;
                else l=m+1;
            }

        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak=peak(mountainArr);
        int ans=bs(mountainArr,0,peak,target,true);
        if(ans!=-1) return ans;
        return bs(mountainArr,peak+1,mountainArr.length()-1,target,false);
    }
}