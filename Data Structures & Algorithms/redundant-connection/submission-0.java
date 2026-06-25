class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);

        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            if (!dsu.union(start, end)) {
                return new int[]{start, end};
            }
        }

        return new int[]{};
    }
}

class DSU {
    int[] rank;
    int[] parent;

    public DSU(int vertex) {
        rank = new int[vertex + 1];
        parent = new int[vertex + 1];
        for (int i = 0; i <= vertex; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // path compression
        }
        return parent[node];
    }

    public boolean union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA == findB) return false; // cycle detected

        if (rank[findA] < rank[findB]) {
            parent[findA] = findB;
        } else if (rank[findA] > rank[findB]) {
            parent[findB] = findA;
        } else {
            parent[findB] = findA;
            rank[findA]++;
        }

        return true;
    }
}
