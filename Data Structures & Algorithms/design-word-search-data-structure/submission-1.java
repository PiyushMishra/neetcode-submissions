class TreeNode {
    TreeNode[] children;
    boolean endOfWord;

    public TreeNode() {
        children = new TreeNode[26];
        endOfWord = false;
    }
}

class WordDictionary {
    
    TreeNode root;

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {

        TreeNode temp = root;

        for(char c: word.toLowerCase().toCharArray()) {
            if(temp.children[c -'a'] == null) {
                temp.children[c -'a'] = new TreeNode();
            }
            temp = temp.children[c-'a'];
        }
        temp.endOfWord = true;

    }

    public boolean search(String word) {
         return dfs(word, 0, root);
    }

    public boolean dfs(String word , int j, TreeNode root) {
         TreeNode temp = root;
         for(int i = j; i < word.length();i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(int k = 0; k < temp.children.length; k++) {
                    TreeNode child = temp.children[k];
                    if(child != null && dfs(word, i+1, child)) {
                       return true;
                    }
                }
                return false;
            }
            else if(temp.children[c -'a'] != null) {
                temp = temp.children[c-'a'];
            } else {
                return false;
            }
            
        }
        return temp.endOfWord; 
    }
}
