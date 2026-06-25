// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.PriorityQueue;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<Pair>()); // index 0 unused
        }

        for (int[] time : times) {
            edges.get(time[0]).add(new Pair(time[1], time[2]));
        }

        return dijkstra(edges, n, k);
    }

    int dijkstra(ArrayList<ArrayList<Pair>> edges, int n, int src) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.dis - b.dis);
        q.offer(new Pair(src, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int u = curr.v;
            if (visited[u]) continue;
            visited[u] = true;

            for (Pair nei : edges.get(u)) {
                if (!visited[nei.v] && dist[nei.v] > dist[u] + nei.dis) {
                    dist[nei.v] = dist[u] + nei.dis;
                    q.offer(new Pair(nei.v, dist[nei.v]));
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}

class Pair {
    int v;
    int dis;

    Pair(int v, int dis) {
        this.v = v;
        this.dis = dis;
    }
}
