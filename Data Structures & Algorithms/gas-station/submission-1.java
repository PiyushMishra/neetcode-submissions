class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;   // tank for current start
        int totalSum = 0;   // total net gas across all stations
        int start = 0;      // candidate start index

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalGas += diff;
            totalSum += diff;

            if (totalGas < 0) {
                // cannot start from current start, move to next station
                totalGas = 0;
                start = i + 1;
            }
        }

        return totalSum >= 0 ? start : -1;
    }
}
