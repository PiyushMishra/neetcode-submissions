
class Solution {

    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> s1FMap = getFreq(s1);

        HashMap<Character, Integer> s2FMap = new HashMap<Character, Integer>();

        int l = 0, r = 0;
        while (r < s2.length()) {

            char c = s2.charAt(r);
            s2FMap.put(c, s2FMap.getOrDefault(c, 0) + 1);

            if (r - l + 1 > s1.length()) {
                char leftChar = s2.charAt(l);
                s2FMap.put(leftChar, s2FMap.get(leftChar) - 1);
                if (s2FMap.get(leftChar) == 0) {
                    s2FMap.remove(leftChar);
                }
                l++;
            }

            if (s1FMap.equals(s2FMap)) {
                return true;
            }
            r++;
        }

        return false;

    }

    public HashMap<Character, Integer> getFreq(String s) {
        HashMap<Character, Integer> hMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            hMap.put(c, hMap.getOrDefault(c, 0) + 1);
        }
        return hMap;

    }

}
