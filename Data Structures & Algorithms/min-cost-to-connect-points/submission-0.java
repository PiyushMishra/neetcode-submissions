
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Min-heap storing [cost, currentNode, fromNode]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        int edgesUsed = 0;

        List<int[]> mstEdges = new ArrayList<>(); // Stores [from, to]

        // Start with node 0, cost 0, from -1
        pq.offer(new int[]{0, 0, -1});

        while (edgesUsed < n) {
            int[] top = pq.poll();
            int cost = top[0];
            int curr = top[1];
            int from = top[2];

            if (visited[curr]) continue;

            visited[curr] = true;
            totalCost += cost;
            edgesUsed++;

            if (from != -1) {
                mstEdges.add(new int[]{from, curr});
            }

            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int nextCost = Math.abs(points[curr][0] - points[next][0]) +
                                   Math.abs(points[curr][1] - points[next][1]);
                    pq.offer(new int[]{nextCost, next, curr});
                }
            }
        }

        // Print the path (edges)
        System.out.println("Edges in MST (from → to):");
        for (int[] edge : mstEdges) {
            System.out.println(edge[0] + " → " + edge[1]);
        }

        return totalCost;
    }
}
