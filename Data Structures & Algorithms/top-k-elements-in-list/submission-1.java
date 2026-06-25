class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(Integer num: nums) {
            hm.put(num, hm.getOrDefault(num, 0) +  1);
        }

        List<Integer> keyset = 
        hm
        .entrySet()
        .stream()
        .sorted(
            Map.Entry.comparingByValue(
                Comparator.reverseOrder()
            ))
        .map(f -> f.getKey())
        .collect(Collectors.toList());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = keyset.get(i);
        }
        return res; 
        
    }
}
