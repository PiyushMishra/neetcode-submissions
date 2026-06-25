class Solution {    
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int slen = s.length();

        HashMap<Character, Integer> hmap = new HashMap<>();

        int maxSoFar = 0;

        while (j < slen) {
            char currentChar = s.charAt(j);

            if (hmap.containsKey(currentChar)) {
                // Jump i to the next position after the last occurrence
                i = Math.max(hmap.get(currentChar) + 1, i);
            }

            hmap.put(currentChar, j);
            maxSoFar = Math.max(maxSoFar, j - i + 1);
            j++;
        }

        return maxSoFar;
    }

}
