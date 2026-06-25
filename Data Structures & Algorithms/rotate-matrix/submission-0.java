class Solution {
    public void rotate(int[][] matrix) {
    
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i+1; j < matrix[0].length; j++) {
            int a = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = a;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            int l = 0;
            int r = matrix[0].length -1; 

            while(l < r) {
                int a = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = a;
                l++;
                r--;
            }
        }
    }
}
