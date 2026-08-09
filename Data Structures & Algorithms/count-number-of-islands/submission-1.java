class Solution {
    public int numIslands(char[][] grid) {
        // your code here

        int m = grid.length;
        int n = grid[0].length;

        int[][] visited  = new int[m][n];

        int num = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
               if(grid[i][j] == '1' && visited[i][j] == 0) {
                  num++;
                  bfs(grid, visited, i, j, m, n);
               }     
            }
        }

        return num;
    }


    public void bfs(char[][] grid, int [][] visited, int i, int j, int m, int n) {

        int[] x = {0,  0, 1, -1};
        int[] y = {1, -1, 0,  0};

        Queue<Pair> queue = new LinkedList<Pair>();

        queue.add(new Pair(i, j));
        visited[i][j] = 1;
         
        while(!queue.isEmpty()) {
           
           Pair p = queue.remove();

           for(int k = 0; k < x.length; k++) {
                int new_x = p.i + x[k];
                int new_y = p.j + y[k];
                if(isValid(new_x, new_y, m, n) && grid[new_x][new_y] == '1' && visited[new_x][new_y] == 0) {
                    queue.add(new Pair(new_x, new_y));
                    visited[new_x][new_y] = 1;
                }
           }
        }  
    }


    public boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}

class Pair {

    public int i;
    public int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}


