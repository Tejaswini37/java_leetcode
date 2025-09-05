class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int top=0,bottom=m-1;
        int left=0,right=n-1;
        List<Integer> res=new ArrayList<Integer>();
        if(matrix==null || n==0) return res;
        while(top<=bottom && left<=right){
            // left -> right
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            // top -> bottom
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            // right -> left
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                res.add(matrix[bottom][i]);
            }
            }
            bottom--;
            // bottom -> top
            if(left<=right){
            for(int i=bottom;i>=top;i--){
                res.add(matrix[i][left]);
            }
            }
            left++;
        }
        return res;
    }
}