class TimeMap {
    private static class Data{
        String val;
        int t;
        public Data(String v,int time){
            val=v;
            t=time;
        }
    }
    Map<String,List<Data>> hm;
    public TimeMap() {
        hm=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)){
            hm.put(key,new ArrayList<>());
        }
        hm.get(key).add(new Data(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)){
            return "";
        }
        List<Data> l=hm.get(key);
        return bs(l,timestamp);
    }
    private String bs(List<Data> a,int timestamp){
        int l=0, r=a.size()-1;
        String res="";
        while(l<=r){
            int m=l+(r-l)/2;
            int time=a.get(m).t;
            if(time==timestamp) return a.get(m).val;
            if(time<timestamp) {
                res=a.get(m).val;
                l=m+1;
            }
            else r=m-1;
        }
        return res;
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */