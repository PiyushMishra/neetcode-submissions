class Solution {

    
    public int numIslands(char[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];
        int count =0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(visited[i][j] == 0 &&  grid[i][j] == '1') {
                    bfs(grid, i, j, grid.length, grid[0].length, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] board, int i, int j, int row, int cols, int[][] visited) {
        
        int[] x = {0, 0, -1, 1};
        int[] y = {1,-1, 0, 0};

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        visited[i][j] = 1; 

        while(!q.isEmpty()) {
           Pair p = q.remove();

           for(int k = 0; k < x.length; k++) {
              int newX = p.i + x[k];
              int newY = p.j + y[k];

              if(isValid(board, newX, newY, board.length, board[0].length, visited)) {
                q.add(new Pair(newX, newY));
                visited[newX][newY] = 1;
              }               
              
           } 
        }
    }


    public boolean isValid(char[][] board, int i, int j, int rows, int cols, int[][] visited) {
        return i >= 0 && i < rows && j >= 0 && j < cols && visited[i][j] == 0 && board[i][j] == '1';
    }

    

}

class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
