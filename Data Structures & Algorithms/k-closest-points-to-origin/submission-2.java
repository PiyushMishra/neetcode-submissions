
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> distance(b) - distance(a));
        int[][] result = new int[k][2];
        int index = 0;
        for(int[] point : points) {
            heap.add(point);
            if(heap.size() > k) {
                heap.poll();
            }
        }

        while (!heap.isEmpty()) {
            result[index++] = heap.poll();
        }


        return result;




    }


    public int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
