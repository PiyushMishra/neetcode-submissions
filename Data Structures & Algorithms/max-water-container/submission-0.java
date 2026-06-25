class Solution {
    public int maxArea(int[] heights) {

        int n = heights.length;

        int i = 0;
        int j = n -1;

        int maxArea = Integer.MIN_VALUE;

        while(i < j) {
            int area = (j-i)*Math.min(heights[i], heights[j]);
            maxArea = Math.max(area, maxArea);
            if (heights[i] <= heights[j]) {
                i++;
            } else {
                j--;
            }

        }

        return maxArea;
    }
}
