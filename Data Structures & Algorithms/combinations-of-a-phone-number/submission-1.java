class Solution {

    HashMap<Character, char[]> hmap = new HashMap<>();

    public Solution() {
        hmap.put('1', new char[]{'1'});
        hmap.put('2', new char[]{'a', 'b', 'c'});
        hmap.put('3', new char[]{'d', 'e', 'f'});
        hmap.put('4', new char[]{'g', 'h', 'i'});
        hmap.put('5', new char[]{'j', 'k', 'l'});
        hmap.put('6', new char[]{'m', 'n', 'o'});
        hmap.put('7', new char[]{'p', 'q', 'r', 's'});
        hmap.put('8', new char[]{'t', 'u', 'v'});
        hmap.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        List<String> global = new ArrayList<>();
        if (digits == null || digits.length() == 0) return global;
        letterCombinations(digits, 0, global, new StringBuilder());
        return global;
    }

    public void letterCombinations(
        String digits,  
        int i, 
        List<String> global,
        StringBuilder res
    ) {
        if (i == digits.length()) {
            global.add(res.toString());
            return;
        }

        for (char c : hmap.get(digits.charAt(i))) {
            res.append(c);
            letterCombinations(digits, i + 1, global, res);
            res.deleteCharAt(res.length() - 1);
        }
    }
}
