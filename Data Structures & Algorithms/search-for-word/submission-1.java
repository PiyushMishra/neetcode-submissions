class Solution {

    private int ROWS, COLS;
    private int[][] visited;
    
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new int[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (existH(board, word, r, c, ROWS, COLS,0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
   
    public boolean existH(
        char[][] board, 
        String word, 
        int i, 
        int j, 
        int rows, 
        int cols, 
        int wordIndex,
        int[][] visited) {

         if (wordIndex == word.length()) {
            return true;
        }    

        if(i < 0 || i >= rows || j <0 || j >= cols) {
            return false;
        } else {
            if(board[i][j] != word.charAt(wordIndex) || visited[i][j] == 1) {
                return false;
            }
        }    

        visited[i][j] = 1;
        boolean res = existH(board, word, i, j+1, rows, cols,wordIndex + 1, visited) ||
        existH(board, word, i, j-1, rows, cols,wordIndex + 1, visited) ||
        existH(board, word, i-1, j, rows, cols,wordIndex + 1, visited) ||
        existH(board, word, i+1, j, rows, cols,wordIndex + 1, visited);
        visited[i][j] = 0;
       
        return res; 
    }
}
