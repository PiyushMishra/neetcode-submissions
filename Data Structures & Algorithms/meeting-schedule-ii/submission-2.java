/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
    // Store the end times of each room.
        Queue<Integer> minHeap = new PriorityQueue<>();
    
        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));
    
        for (Interval interval : intervals) {
          // There's no overlap, so we can reuse the same room.
          if (!minHeap.isEmpty() && interval.start >= minHeap.peek())
            minHeap.poll();
          minHeap.offer(interval.end);
        }
    
        return minHeap.size();
      }
}
