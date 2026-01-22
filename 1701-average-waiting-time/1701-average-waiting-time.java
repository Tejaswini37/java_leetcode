class Solution {
    public double averageWaitingTime(int[][] customers) {
        int sum[]=new int[customers.length];
        int time=customers[0][0];
        for(int i=0;i<customers.length;i++){
            int at=customers[i][0];
            int wt=customers[i][1];
            if(at>=time){
                sum[i]=wt;
                time=at+wt;
            } 
            else {
                sum[i]=time-at+wt;
                time+=wt;
            }
        }
        double avg=0;
        for(int s : sum) avg+=s;
        return (double)avg/customers.length;
    }
}