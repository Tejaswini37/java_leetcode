class Solution {
    public void dfs(String s,List<String> path,Map<String,PriorityQueue<String>> mp){
        while(mp.containsKey(s) && !mp.get(s).isEmpty()){
            dfs(mp.get(s).poll(),path,mp);
        }
        path.addFirst(s);  // or use add() and reverse path at last
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> flights=new HashMap<>();
        for(List<String> l : tickets){
            String from=l.get(0);
            String to=l.get(1);
            if(!flights.containsKey(from)) flights.put(from,new PriorityQueue<>());
            flights.get(from).add(to);
        }
        List<String> path=new ArrayList<>();
        dfs("JFK",path,flights);
        return path;
    }
}