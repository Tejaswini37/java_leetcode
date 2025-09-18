class SmallestInfiniteSet {
    private int cur;
    private PriorityQueue<Integer> pq; // minheap
    private Set<Integer> addedBack;
    public SmallestInfiniteSet() {
        pq=new PriorityQueue<>();
        addedBack=new HashSet<>();
        cur=1;
    }
    
    public int popSmallest() {
        if(!pq.isEmpty()){
            int smallest=pq.poll();
            addedBack.remove(smallest);
            return smallest;
        }
        return cur++;
    }
    
    public void addBack(int num) {
        //num>=cur it already exists 
        if(num<cur && !addedBack.contains(num)){
            addedBack.add(num);
            pq.add(num);
        }
    }
}
// but minHeap.contains(num) is O(n).
// If there are thousands of addBack calls, this becomes slow.
// HashSet.contains(num) is O(1) on average.
// Without HashSet → Correct, but inefficient (O(n) check each time).

// With HashSet → Correct and efficient (O(1) check + O(log n) insert).

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */