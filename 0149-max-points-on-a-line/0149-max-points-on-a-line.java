class Solution {
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int maxPoints(int[][] points) {
        int n=points.length;
        if(n<=2) return n;
        int res=0;
        for(int i=0;i<n;i++){
            Map<String,Integer> hm=new HashMap<>();
            int overlap=0;
            int maxi=0;
            for(int j=i+1;j<n;j++){
                int dx=points[j][0]-points[i][0];
                int dy=points[j][1]-points[i][1];
                if(dx==0 && dy==0){
                    overlap++; //duplicate
                    continue;
                }
                int g= gcd(dx,dy);
                dx/=g;
                dy/=g;
                //normalize sign
                if(dx<0){
                    dx=-dx;
                    dy=-dy;
                }
                else if(dx==0 && dy<0){
                    dy=-dy;
                }
                String key=dx+" "+dy;
                int val=hm.getOrDefault(key,0)+1;
                hm.put(key,val);
                maxi=Math.max(maxi,val);
            }
            res=Math.max(res,maxi+overlap+1);
        }
        return res;
    }
}
// For every point i treat it as a base point.

// For every other point j > i compute the slope between i and j as the reduced pair (dx, dy) where dx = xj - xi, dy = yj - yi, reduced by gcd(dx,dy).
// Count how many other points share that same reduced slope relative to i using a map. The largest count for a slope plus duplicate points and the base point itself gives the number of collinear points through i.

// Repeat for each base i, and return the global maximum.

// Points: [(1,1),(2,2),(3,3),(1,1)] (4 points; last is a duplicate of first)

// Take i = 0 base (1,1):

// j = 1 (2,2): dx=1, dy=1, gcd=1 → reduced slope (1,1). map[(1)][1] = 1 → max = 1.

// j = 2 (3,3): dx=2, dy=2, gcd=2 → reduced (1,1). map[(1)][1] = 2 → max = 2.

// j = 3 (1,1): dx=0, dy=0 → duplicate → overlap = 1.
// Result for base 0: max + overlap + 1 = 2 + 1 + 1 = 4. (All 4 points lie on same line; duplicates included.)

// This is exactly the intended behavior.

// WHY NORMALIZE?

// From (1,1) to (2,2): dx = 1, dy = 1 → slope (1,1)

// From (2,2) to (1,1): dx = -1, dy = -1 → slope (-1,-1)
// Rule 1: If dx < 0, flip both signs
// Example: slope (-1,-1) → becomes (1,1)

// Example: slope (-2,4) → gcd=2 → (-1,2) → becomes (1,-2)
// This ensures all slopes are stored with positive dx.

// Rule 2: If dx == 0 (vertical line), force dy > 0
// Vertical line slope: (0,1) and (0,-1) are the same.

// Without fixing, sometimes you’d store (0,1) and other times (0,-1).

// This rule ensures we always use (0,1) for vertical lines.

// Summary of normalization

// dx > 0 → slope stored as is.

// dx < 0 → flip signs so dx becomes positive.

// dx = 0 → force dy positive (vertical line always looks like (0,1)).