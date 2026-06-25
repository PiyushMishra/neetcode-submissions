class Solution {
    public int maxProfit(int[] prices) {
        
      int l = 0;
      int r = 1;
      int min = Integer.MAX_VALUE;

      int max = 0;

      while(r < prices.length) {

        min = Math.min(min, prices[l]);
        
        max = Math.max(max, prices[r] - min);

        r++;
        l++;
      }

      return max;

    }
}
