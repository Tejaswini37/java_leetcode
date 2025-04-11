class Solution {
    public String reverseOnlyLetters(String s) {
        char[] a=s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<=j){
            while(i<=j && !Character.isLetter(a[i])) i++;
            while(i<=j && !Character.isLetter(a[j])) j--;
            if(i<=j){
                char t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
            i++;
            j--;

        }
        return new String(a);
    }
}