class Solution {
    public int missingNumber(int[] nums) {

     return Arrays.stream(nums).reduce((a, b) -> a^b).orElse(-1)^( 
            IntStream.rangeClosed(0, nums.length).reduce((a,b) -> a^b).orElse(-1)
        );
        
    }
}
