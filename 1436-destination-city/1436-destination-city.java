class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> hs=new HashSet<>();
        for(List<String> path : paths){
            hs.add(path.get(0));
        }
        // city doesn't appear as source
        for(List<String> path : paths){
            if(!hs.contains(path.get(1))) return path.get(1);
        }
        return "";
    }
    
}

// class Solution {
//     public String destCity(List<List<String>> paths) {

//         HashSet<String> set = new HashSet<>();

//         for (List<String> path : paths) {
//             set.add(path.get(0));
//             set.remove(path.get(1));
//         }

//         return set.iterator().next();
//     }
// }
