class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            // prerequisites[i] = [a, b] means b -> a
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                boolean hasCycle = dfs(adj, i, visited, pathVisited, stack);
                if (hasCycle) {
                    return new int[] {}; // cycle detected
                }
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }

    public boolean dfs(
        ArrayList<ArrayList<Integer>> adj,
        int node,
        int[] visited,
        int[] pathVisited,
        Stack<Integer> stack
    ) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for (Integer neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                if (dfs(adj, neighbor, visited, pathVisited, stack)) {
                    return true;
                }
            } else if (pathVisited[neighbor] == 1) {
                return true; // cycle detected
            }
        }

        pathVisited[node] = 0;
        stack.push(node);
        return false;
    }
}
