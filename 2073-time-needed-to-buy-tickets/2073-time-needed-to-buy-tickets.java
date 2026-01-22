class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time=0;
        for(int i=0;i<tickets.length;i++){
            if(i<=k){
                time+=Math.min(tickets[i],tickets[k]);
            }
            else time+=Math.min(tickets[i],tickets[k]-1);
        }
        return time;
    }
}
// Person k buys tickets[k] tickets

// Every person before or at k can buy at most tickets[k] tickets

// Every person after k can buy at most tickets[k] - 1 tickets

// Why?

// After person k finishes their last ticket, the process stops immediately