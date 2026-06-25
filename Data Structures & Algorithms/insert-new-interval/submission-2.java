

class Solution {
  /**
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        Arrays.sort(intervals, java.util.Comparator.comparingInt(a -> a[0]));

        ArrayList<int[]> res = new ArrayList<>();

        int[] curr = newInterval;

        for(int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] > curr[1]) {
               res.add(curr);
               curr = intervals[i];
            } else if(intervals[i][1] < curr[0]) {
              res.add(intervals[i]);
            } else {
               curr[0] = Math.min(intervals[i][0],  curr[0]);
               curr[1] = Math.max(intervals[i][1],  curr[1]);
            }
            
        }

        res.add(curr);
        
        int[][] res1 = new int[res.size()][];
        
        for(int i = 0; i < res.size(); i++) {

            res1[i] = res.get(i);

        }
        
        return res1;
    }
}
