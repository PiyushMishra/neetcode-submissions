class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        ArrayList<int[]> al = new ArrayList<>();
        
        int[] curr = intervals[0];

        for(int i = 1; i < intervals.length; i++) {
            if(curr[1] >= intervals[i][0]) {
                curr[1] = Math.max(intervals[i][1], curr[1]);
            } else {
                al.add(curr);
                curr = intervals[i];
            }
        } 

        al.add(curr);

        return al.toArray(new int[al.size()][]);   
        
    }
}
