class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int heights[]=new int[n];
        int maxArea=0;
        for(int i=0;i<m;i++){
            // Build histogram for row i
            for(int j=0;j<n;j++){
                if(matrix[i][j] == '1') heights[j]+=1;
                else heights[j] = 0;
            }
            // Compute max rectangle in histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    private int largestRectangleArea(int heights[]){
        Stack<Integer> st=new Stack<>();
        int maxArea= 0;
        int n=heights.length;
        for(int i=0;i<=n;i++){ // ✅ note: i <= n (to handle last element)
            int h=(i==n) ? 0: heights[i];
            while(!st.isEmpty() && h< heights[st.peek()]){
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i: i-st.peek()-1;
                maxArea= Math.max(maxArea, height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}


