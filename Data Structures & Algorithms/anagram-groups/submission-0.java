class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

       Map<String, ArrayList<String>> res = new HashMap<String, ArrayList<String>>();    

       for(String s: strs) {
        String freq = getFreq(s);
        res.putIfAbsent(freq, new ArrayList());
        res.get(freq).add(s);
       }
       return new ArrayList<>(res.values());
    }


    public String getFreq(String s) { 

        int[] res = new int[26];

        for(int i =0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++; 
        }

        return Arrays.toString(res);

       
    }




}
