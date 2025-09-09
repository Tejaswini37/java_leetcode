class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        int projects[][]=new int[n][2];
        for(int i=0;i<n;i++){
            projects[i][0]=capital[i];
            projects[i][1]=profits[i];
        }
        // sort projects by capital required
        Arrays.sort(projects, (a,b)-> a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        for(int j=0;j<k;j++){
            while(i<n && projects[i][0]<=w){
                pq.offer(projects[i][1]);
                i++;
            }
            if(pq.isEmpty()) return w;
            w+=pq.poll();
        }
        return w;
    }
}
// Sort projects by capital required.

// Use a max-heap for profits of projects you can afford.

// Repeat up to k times:

// Push all projects with capital[i] ≤ current capital into max-heap.

// Pop the project with maximum profit.

// Add profit to current capital.