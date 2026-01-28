class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] health, String directions) {
        int n=positions.length;
        // indices sorted by position
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++) idx[i]=i;
        Arrays.sort(idx,(a,b)->positions[a]-positions[b]);
        Stack<Integer> st=new Stack<>();
        for(int i : idx){
            if(directions.charAt(i)=='R') st.push(i);
            else{
                while(!st.isEmpty() && health[i]>0){
                    int j=st.peek(); //right moving robot
                    if(health[j]<health[i]){
                        health[j]=0;
                        health[i]--;
                        st.pop();
                    }
                    else if(health[i]==health[j]){
                        health[j]=0;
                        health[i]=0;
                        st.pop();
                    }
                    else{
                        health[i]=0;
                        health[j]--;
                        // st.pop();
                    }
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int x : health){
            if(x>0) ans.add(x);
        }
        return ans;
    }
}

 