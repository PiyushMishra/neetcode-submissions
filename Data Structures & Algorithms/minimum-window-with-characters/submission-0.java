class Solution {
    public String minWindow(String s, String t) {

         if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        HashMap<Character, Integer> tFreqMap = getfreq(t); 
        HashMap<Character, Integer> sFreqMap = new HashMap<>();
        
        int minLength = Integer.MAX_VALUE;

        int minStart = 0;
        int l = 0;
        int r = 0;

        while(r < s.length()) {
           sFreqMap.put(s.charAt(r), sFreqMap.getOrDefault(s.charAt(r), 0) + 1);
           boolean isValid = true;
                for(char c : tFreqMap.keySet()) {  // Only change: iterate through tFreqMap keys instead of toCharArray
                    if(!sFreqMap.containsKey(c) || sFreqMap.get(c) < tFreqMap.get(c)) {  // Check if character exists and has sufficient frequency
                        isValid = false;
                        break;
                    }
                }

                if(isValid) {
                    // shrink the window;
                    while(l <= r && (!tFreqMap.containsKey(s.charAt(l)) || sFreqMap.get(s.charAt(l)) > tFreqMap.get(s.charAt(l)))) {  // Fix shrinking condition
                        sFreqMap.put(s.charAt(l), sFreqMap.get(s.charAt(l)) - 1);  // This line was correct
                        if(sFreqMap.get(s.charAt(l)) == 0) sFreqMap.remove(s.charAt(l));
                        l++;
                    }
                    
                    // Update min window if current is smaller
                    if(r - l + 1 < minLength) {  // This was also fixed in your updated code
                        minLength = r - l + 1;
                        minStart = l;
                    }
                }

                r++;
           }

           return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }
    
    public HashMap<Character, Integer> getfreq(String s) {
        HashMap<Character, Integer> hMap = new HashMap<>();
          for (Character c : s.toCharArray()) { 
            hMap.put(c, hMap.getOrDefault(c, 0) + 1);
          }
          return hMap;
    }
}