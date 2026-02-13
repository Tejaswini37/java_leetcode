class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<String,Integer> map=new HashMap<>();
        long ans=0;
        for(int r[]: rectangles){
            int w=r[0], h=r[1];
            int g=gcd(w,h);
            w/=g;
            h/=g;
            String key=w+"/"+h;
            map.put(key,map.getOrDefault(key,0)+1);
            ans+=map.get(key)-1;
        }
        return ans;
    }
    public int gcd(int a,int b){
        return (b==0)?a:gcd(b,a%b);
    }
}
// class Solution {
//     public long interchangeableRectangles(int[][] rectangles) {

//         Map<String, Long> map = new HashMap<>();
//         long ans = 0;

//         for (int[] r : rectangles) {
//             int w = r[0], h = r[1];
//             int g = gcd(w, h);

//             w /= g;
//             h /= g;

//             String key = w + "/" + h;

//             long cnt = map.getOrDefault(key, 0L);
//             ans += cnt;           // pairs formed with previous same ratios
//             map.put(key, cnt + 1);
//         }

//         return ans;
//     }

//     private int gcd(int a, int b) {
//         return b == 0 ? a : gcd(b, a % b);
//     }
// }
