
class Solution { 
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        java.util.Arrays.sort(intervals, java.util.Comparator.comparingInt(a -> a[0]));
        int count = 0;
        int[] current = intervals[0];
        int r = 1;
        while(r < intervals.length) {
            if(current[1] > intervals[r][0]) {
                current[1] = Math.min(current[1], intervals[r][1]);
                count++;
            }
            else {
                current = intervals[r];
            }

            r++;
        }
        
        return count;
    }
}
