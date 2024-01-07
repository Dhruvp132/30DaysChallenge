class Solution {
    int[][] matrix;
    int a; 
    int b; 
    public Solution(int m, int n) {
        matrix = new int[m][n];
        a = m;
        b = n;
    }
    
    public int[] flip() {
        int row = (int) ((Math.random() * ((a) - 0)) + 0);
        int col = (int) ((Math.random() * ((b) - 0)) + 0);
        if(matrix[row][col] == 1) flip();
        matrix[row][col] = 0;
        return new int[]{row, col};
    }
    
    public void reset() {
        matrix = new int[a][b];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */