class Solution {
    public boolean isAnagram(String s, String t) { 


        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length();i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length();i++) {
            hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i),0) -1);
        }

        Set<Map.Entry<Character, Integer>> es =  hashMap.entrySet();

        for(Map.Entry<Character, Integer> e: es) {
            if(e.getValue() != 0) return false; 
        }  

          
        
        return true;
    }
}
