class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int c=0;
        for(int h :hours){
            if(h>=target) c++;
        }
        return c;
    }
}