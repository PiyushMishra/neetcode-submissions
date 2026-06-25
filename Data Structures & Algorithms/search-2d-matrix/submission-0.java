class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {


       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
       
        int l = 0;
        int r = matrix.length*matrix[0].length -1;

        while(l <= r) {
           int mid = (l + r)/2;
           int row = mid/matrix[0].length;
           int col = mid%matrix[0].length;
           if(target == matrix[row][col]) {
              return true;
           } else if (target > matrix[row][col]) {
                l = mid + 1;   // go right
            } else {
                r = mid - 1;   // go left
            }

        }
      return false;   
    }
}
