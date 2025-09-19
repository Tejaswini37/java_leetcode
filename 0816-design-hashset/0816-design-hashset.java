class MyHashSet {
    private boolean mp[];
    public MyHashSet() {
        mp=new boolean[1000001];
        Arrays.fill(mp,false);
    }
    
    public void add(int key) {
        mp[key]=true;
    }
    
    public void remove(int key) {
        mp[key]=false;
    }
    
    public boolean contains(int key) {
        return mp[key];
    }
}
// Let inheritece handle every thing
// class MyHashSet extends HashSet<Integer> {}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

 
//  class MyHashSet {
//     int n = 10000;
//     List<Integer>[] arr;

//     public MyHashSet() {
//         arr = new ArrayList[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = new ArrayList<>();
//         }
//     }

//     public void add(int key) {
//         int idx = key % n;
//         if (!arr[idx].contains(key)) {
//             arr[idx].add(key);
//         }
//     }

//     public void remove(int key) {
//         int idx = key % n;
//         arr[idx].remove(Integer.valueOf(key));
//     }

//     public boolean contains(int key) {
//         int idx = key % n;
//         return arr[idx].contains(key);
//     }
// }