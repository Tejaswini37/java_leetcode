class Solution {
    public double[] sampleStats(int[] count) {
        double[] ans=new double[5];
        int min=-1,max=-1,maxOccurence=0,mode=0;
        long elements=0,sum=0;
        for(int i=0;i<count.length;i++){
            if(count[i]==0) continue;
            elements+=count[i];
            if(min==-1) min=i;
            if(count[i]>maxOccurence){
                maxOccurence=count[i];
                mode=i;
            }
            max=i;
            sum+=i*(long)count[i];
        }
        ans[0]=min;
        ans[1]=max;
        ans[2]=sum/(double)elements;
        ans[3]=getMedian(elements,count);
        ans[4]=mode;
        return ans;
    }
    static double getMedian(long elements,int count[]){
        int sum=0,index=0,previous=0;
        for(int i=0;i<count.length;i++){
            if(count[i]==0) continue;
            sum+=count[i];
            if(sum>=elements/2+1){
                index=i;
                break;
            }
            previous=i;
        }
        if(elements%2==1) return index;
        if(sum-count[index]>=elements/2)
        return (index+previous)/2.0;
        return index;
    }
}