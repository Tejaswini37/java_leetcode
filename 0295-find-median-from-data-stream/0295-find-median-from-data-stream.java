class MedianFinder {
    PriorityQueue<Integer> left; //max-heap first half
    PriorityQueue<Integer> right;// min-heap second half
    public MedianFinder() {
        left=new PriorityQueue<>(Collections.reverseOrder());
        right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if(right.size()>left.size()){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if(right.size()==left.size()){
            return (right.peek()+left.peek())/2.0;
        }
        else return (double)left.peek();
    }
}
/*  ex=[1,2,3,4] do it
Max‑heap (left) holds the smaller half of all numbers.
Its root (left.peek()) is the largest of the small half.
Min‑heap (right) holds the larger half of all numbers.
Its root (right.peek()) is the smallest of the large half.

Always push the new number into the max‑heap (left).
This ensures anything that belongs to the “small half” ends up there, at least temporarily.

Rebalance step 1: Move the largest of the small half (left.poll()) into the min‑heap (right).
Now every element in left is ≤ every element in right.

This restores the ordering invariant between the two halves.

Rebalance step 2: If the min‑heap is now bigger (has more elements than left), move its smallest (right.poll()) back into the max‑heap (left).
Every element in left ≤ every element in right. */
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */