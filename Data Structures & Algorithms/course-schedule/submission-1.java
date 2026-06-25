// import java.util.ArrayList;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];  
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (dfs(adj, i, visited, pathVisited)) {
                    return false;
                }
            }
        }
        return true;

    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, int[] visited, int[] pathVisited) {
 
        visited[node] = 1;
        pathVisited[node] = 1;

        for(Integer neighbor: adj.get(node)) {
            if(visited[neighbor] == 0) {
              visited[neighbor] = 1;   
              if(dfs(adj, neighbor, visited, pathVisited)) {
                return true;
              }
            } else {
               if(pathVisited[neighbor] == 1) return true;
            }  
        }
        
        pathVisited[node] = 0;
        return false;

    }
}