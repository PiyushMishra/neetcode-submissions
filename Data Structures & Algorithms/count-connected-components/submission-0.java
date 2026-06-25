// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Queue;

class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> edgeList = new ArrayList<>();

        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            edgeList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            edgeList.get(edges[i][0]).add(edges[i][1]);
            edgeList.get(edges[i][1]).add(edges[i][0]);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                bfs(i, edgeList, visited);
                count++;
            }
        }

        return count;

    }

    public void bfs(int vertex, List<List<Integer>> edgeList, int[] visited) {

        Queue<Integer> q = new LinkedList<Integer>();

        q.add(vertex);
        visited[vertex] = 1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (Integer nei : edgeList.get(node)) {
                if (visited[nei] == 0) {
                    visited[nei] = 1;
                    q.offer(nei);
                }
            }

        }
    }
}
