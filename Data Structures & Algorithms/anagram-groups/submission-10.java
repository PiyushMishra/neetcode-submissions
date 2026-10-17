class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> hmap = new HashMap<>();

        for(String word: strs) {
            String freq = getFreq(word);
            hmap.putIfAbsent(freq, new ArrayList<String>());
            hmap.get(freq).add(word);   
        }

        return new ArrayList(hmap.values());
    }

    public String getFreq(String word) {
        
        int[] freq = new int[26];
        
        for(char c: word.toCharArray()) {
            freq[c - 'a']++;
        }

        return Arrays.toString(freq);

    }
}


