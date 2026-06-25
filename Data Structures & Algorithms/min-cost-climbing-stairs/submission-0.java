class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] costN = new int[cost.length+1];

        costN[0] = 0;
        costN[1] = 0;

        for(int i = 2; i <= cost.length; i++) {
            costN[i] = Math.min(costN[i-2] + cost[i-2], costN[i-1] + cost[i-1]);
        }        

        return costN[cost.length];
    }
}
