class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {
        int n=pos.length,res=0;
        double[][] cars=new double[n][2];
        for(int i=0;i<n;i++){
            cars[i]=new double[]{pos[i],(double)(target-pos[i])/speed[i]};
        }
        Arrays.sort(cars,(a,b)->Double.compare(a[0],b[0]));
        double prev=0;
        for(int i=n-1;i>=0;i--){
            if(cars[i][1]>prev){
                prev=cars[i][1];
                res++;
            }
        }
        return res;
    }
}

    //     public int carFleet(int target, int[] pos, int[] speed) {
    //     Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());
    //     for (int i = 0; i < pos.length; ++i)
    //         m.put(pos[i], (double)(target - pos[i]) / speed[i]);
    //     int res = 0; double cur = 0;
    //     for (double time : m.values()) {
    //         if (time > cur) {
    //             cur = time;
    //             res++;
    //         }
    //     }
    //     return res;
    // }