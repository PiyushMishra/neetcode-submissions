class Solution {

    public int orangesRotting(int[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }
        int count = bfs(grid, q, grid.length, grid[0].length, visited);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1; // If any fresh orange remains
                }
            }
        }
        return count;
    }

    public int bfs(int[][] board, Queue<Pair> q, int row, int cols, int[][] visited) {

        int count = 0;
        int[] x = { 0, 0, -1, 1 };
        int[] y = { 1, -1, 0, 0 };

        while (!q.isEmpty()) {

            int size = q.size();
            while (size-- > 0) {

                Pair p = q.remove();

                for (int k = 0; k < x.length; k++) {
                    int newX = p.i + x[k];
                    int newY = p.j + y[k];

                    if (isValid(board, newX, newY, board.length, board[0].length, visited)) {
                        q.add(new Pair(newX, newY));
                        board[newX][newY] = 2; // Mark as rotten
                        visited[newX][newY] = 1;
                    }
                }
            }
            count++;
        }
        return count == 0 ? 0 : count - 1;
    }

    public boolean isValid(int[][] board, int i, int j, int rows, int cols, int[][] visited) {
        return i >= 0 && i < rows && j >= 0 && j < cols && visited[i][j] == 0 && board[i][j] == 1;
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
