class Solution {
    public boolean hasDuplicate(int[] nums) { 

        HashSet<Integer> hashSet = new HashSet<Integer>();

        for(Integer num : nums) {
            if(hashSet.contains(num)) return true;
            else {
                hashSet.add(num);
            }
        } 

        return false;
 
    }
}
