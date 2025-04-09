class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int c=0;
        int n=people.length;
        int l=0;
        int r=n-1;
        while(l<=r){
            if(people[l]+people[r]<=limit) l++;
            c++;
            r--;
        }
        return c;
    }
}