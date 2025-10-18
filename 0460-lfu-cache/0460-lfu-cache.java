
class LFUCache {
    private int capacity;
    private int minFreq;
    private Map<Integer, int[]> keyToValFreq; // key -> [value, freq]
    private Map<Integer, Queue<Integer>> freqToKeys; // freq -> queue of keys

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToValFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValFreq.containsKey(key)) return -1;

        int[] valFreq = keyToValFreq.get(key);
        int val = valFreq[0];
        int freq = valFreq[1];

        // remove key from old freq queue
        freqToKeys.get(freq).remove(key);

        // if that was the only key of minFreq, increment minFreq
        if (freq == minFreq && freqToKeys.get(freq).isEmpty()) {
            minFreq++;
        }

        // add key to new freq queue
        freqToKeys.computeIfAbsent(freq + 1, f -> new LinkedList<>()).add(key);

        // update map
        keyToValFreq.put(key, new int[]{val, freq + 1});

        return val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        // if key exists, just update its value and frequency
        if (keyToValFreq.containsKey(key)) {
            keyToValFreq.put(key, new int[]{value, keyToValFreq.get(key)[1]});
            get(key); // increase frequency
            return;
        }

        // cache full → remove LFU key
        if (keyToValFreq.size() == capacity) {
            Queue<Integer> lfuKeys = freqToKeys.get(minFreq);
            int lfuKey = lfuKeys.poll(); // remove first key (no iterator!)
            if (lfuKeys.isEmpty()) {
                freqToKeys.remove(minFreq);
            }
            keyToValFreq.remove(lfuKey);
        }

        // insert new key with freq = 1
        keyToValFreq.put(key, new int[]{value, 1});
        freqToKeys.computeIfAbsent(1, f -> new LinkedList<>()).add(key);
        minFreq = 1; // reset minFreq
    }
}



// 1️⃣ HashMap keyToValFreq
// Stores mapping of each key to its value and frequency.
// 2️⃣ HashMap freqToKeys
// Maps each frequency → keys that have this frequency (in LRU order).
// We can store these keys using LinkedHashSet (it remembers insertion order).
// 3️⃣ Integer minFreq
// Tracks the minimum frequency currently present in the cache.

// \U0001f539 get(key)
// If key not found → return -1.
// Else, increase its frequency:
// Remove key from old frequency list.
// Add it to new frequency list (freq + 1).
// Update minFreq if needed.
// Return its value.

// \U0001f539 put(key, value)
// If capacity = 0 → do nothing.
// If key already exists → update its value and call get(key) to increase its frequency.
// Else:
// If cache is full → remove LFU key:
// That’s the first element from freqToKeys.get(minFreq).
// Add new key with frequency = 1.
// Set minFreq = 1.

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 