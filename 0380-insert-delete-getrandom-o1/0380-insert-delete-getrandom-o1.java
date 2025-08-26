class RandomizedSet {
    HashMap<Integer,Integer> hm;
    List<Integer> l;
    Random rand;
    public RandomizedSet() {
        hm=new HashMap<>();
        l=new ArrayList<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)) return false;
        hm.put(val,l.size());
        l.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)) return false;
        int idx=hm.get(val);
        int last=l.get(l.size()-1);
        l.set(idx,last);
        hm.put(last,idx);
        hm.remove(val);
        l.remove(l.size()-1);
        return true;
    }
    
    public int getRandom() {
        int idx=rand.nextInt(l.size());
        return l.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

//  1. Why not just use a list or set?

// A list allows getRandom() easily (because of index access), but remove() is O(n) (need to shift elements).

// A set (hashset) allows insert and remove in O(1), but getRandom() is O(n) if we need uniform random (since we’d have to convert set → list).

// \U0001f449 Neither alone works. We need to combine both.

// . Trick for remove(val)

// When we remove a value, we don’t want O(n) shifting.
// \U0001f449 So instead:

// Look up the index of val in the HashMap.

// Swap it with the last element in the list.

// Update the HashMap for the swapped element.

// Pop the last element from the list.

// This keeps everything O(1).