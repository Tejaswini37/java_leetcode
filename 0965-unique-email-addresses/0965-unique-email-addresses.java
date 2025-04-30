class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> h=new HashSet<>();
        for(int i=0;i<emails.length;i++){
            String s[]=emails[i].split("@");
            String local=s[0];
            String domain=s[1];
            local=local.split("\\+")[0];
            local=local.replace(".","");
            h.add(local+'@'+domain);
        }
        return h.size();
    }
}