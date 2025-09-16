class Solution {
    public String predictPartyVictory(String senate) {
        int n=senate.length();
        Queue<Integer> radiants=new LinkedList<>();
        Queue<Integer> dires=new LinkedList<>();
        // put indexes of senators into queues
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R') radiants.offer(i);
            else dires.offer(i);
        }
        // simulate rounds
        while(!dires.isEmpty() && !radiants.isEmpty()){
            int r=radiants.poll();
            int d=dires.poll();
            if(r<d) radiants.add(n+r);
            else dires.add(n+d);
        }
        return radiants.isEmpty()?"Dire":"Radiant";
    }
}

// Take the front senator from each queue (r from radiant, d from dire).

// Compare their indexes:

// If r < d → Radiant senator gets the turn first, so:

// He bans that Dire senator.

// He survives to the next round → push him back with index r + n.

// If d < r → Dire senator gets the turn first → same idea.

// Repeat until one queue is empty.

// Radiant index = 0 s = "RDD" (n = 3)
// Dire indexes = 1, 2
// Round 1: r=0, d=1 → Radiant goes first, bans Dire at 1, Radiant survives → push 0+3=3 back.

// Now Radiant queue = [3], Dire queue = [2]
// → Next round continues correctly because index 2 happens before index 3.