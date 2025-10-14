class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res=new ArrayList<String>();
        if(num==null || num.length()==0) return res;
        helper(res,"",num,target,0,0,0);
        return res;
    }
    public void helper(List<String> res, String path, String num,int tar,int pos, long eval,long last_operand){
        if(pos==num.length()){
            if(tar==eval) res.add(path);
            return ;
        }
        for(int i=pos;i<num.length();i++){
            if(i!=pos && num.charAt(pos)=='0') break;
            // for num="05" i=1,pos=0 then we can't take number as "05" so break;
            long cur=Long.parseLong(num.substring(pos,i+1));
            String cur_num=num.substring(pos,i+1);
            if(pos==0){
                helper(res,path+cur,num,tar,i+1,cur,cur);
            }
            else{
                helper(res,path+"+"+cur_num,num,tar,i+1,eval+cur,cur);
                helper(res,path+"-"+cur_num,num,tar,i+1,eval-cur,-cur);
                helper(res,path+"*"+cur_num,num,tar,i+1,eval-last_operand+last_operand*cur,cur*last_operand);
            }
        }
    }
}


//     public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
//         if(pos == num.length()){
//             if(target == eval)
//                 rst.add(path);
//             return;
//         }
//         for(int i = pos; i < num.length(); i++){
//             if(i != pos && num.charAt(pos) == '0') break;
//             long cur = Long.parseLong(num.substring(pos, i + 1));
//             if(pos == 0){
//                 helper(rst, path + cur, num, target, i + 1, cur, cur);
//             }
//             else{
//                 helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
//                 helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                
//                 helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
//             }
//         }
//     }
// }