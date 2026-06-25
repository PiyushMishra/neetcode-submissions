class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        HashMap<Character, Character> hmap = new HashMap<Character, Character>();
        
        hmap.put('}', '{');
        hmap.put(')', '(');
        hmap.put(']', '[');

        for(int i = 0; i < s.length(); i++) {
            
            if(hmap.values().contains(s.charAt(i))) {
                st.push(s.charAt(i));
            }

            if(hmap.keySet().contains(s.charAt(i))) {
                if(st.isEmpty()) return false;
                if(st.pop() != hmap.get(s.charAt(i))) {
                    return false;
                }
            }
        }

        return st.isEmpty();
        
    }
}
