class Solution {
    public String mergeAlternately(String word1, String word2) {

        int word1len = word1.length();
        int word2len = word2.length();
        int i = 0;
        int j = 0; 

        StringBuilder sb = new StringBuilder();

        while(i < word1len && j < word2len) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        } 

        while(i < word1len) {
            sb.append(word1.charAt(i));
            i++;
        }
        

        while(j < word2len) {
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
        
    }
}