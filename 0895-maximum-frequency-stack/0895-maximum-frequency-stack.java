class FreqStack {
    HashMap<Integer,Integer> fmap;
    List<Stack<Integer>> sl;  // stack list
    public FreqStack() {
        fmap=new HashMap<>();
        sl=new ArrayList<>();
        sl.add(new Stack());
    }
    
    public void push(int val) {
        int freq=fmap.getOrDefault(val,0)+1;
        fmap.put(val,freq);
        if(freq==sl.size()) sl.add(new Stack<>());
        sl.get(freq).add(val);
    }
    
    public int pop() {
        Stack<Integer> top=sl.get(sl.size()-1);
        int x=top.pop();
        if(top.size()==0) sl.remove(sl.size()-1);
        fmap.put(x,fmap.get(x)-1);
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
