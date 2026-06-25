class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashSet  = new HashMap<Integer, Integer>();

        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int less = target - nums[i]; 
            if(hashSet.containsKey(less)) {
                res[0] = i;
                res[1] = hashSet.get(less);
                break;
            }

            hashSet.put(nums[i], i);
            
            
        }

        Arrays.sort(res); 
 
        return res;
        
    }
}
