class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Tree must have exactly n-1 edges
        if (edges.length != n - 1) return false;

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Undirected
        }

        int[] visited = new int[n];

        // Check for cycle
        if (checkCycle(adj, 0, -1, visited)) return false;

        // Check for connectivity
        for (int v : visited) {
            if (v == 0) return false;
        }

        return true;
    }

    public boolean checkCycle(
        ArrayList<ArrayList<Integer>> adj, 
        int currNode,
        int parent,
        int[] visited
    ) {
        visited[currNode] = 1;

        for (Integer neighbour : adj.get(currNode)) {
            if (visited[neighbour] == 0) {
                if (checkCycle(adj, neighbour, currNode, visited)) {
                    return true;
                }
            } else if (neighbour != parent) {
                return true; // Cycle found
            }
        }

        return false;
    }
}
