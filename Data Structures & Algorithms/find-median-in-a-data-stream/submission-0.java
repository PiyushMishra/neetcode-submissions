class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
       if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

    }
    
    public double findMedian() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if(minSize == maxSize) {
            return (double) (minHeap.peek() + maxHeap.peek())/2;
        } else if(minSize > maxSize) {
            return (double) minHeap.peek();
        } else {
            return (double) maxHeap.peek();
        }
    } 
}
