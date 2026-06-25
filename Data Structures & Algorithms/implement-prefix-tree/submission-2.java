class TreeNode {
    TreeNode[] children;
    boolean endOfWord;

    public TreeNode() {
        children = new TreeNode[26];
        endOfWord = false;
    }
}

class PrefixTree {
    
    TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {

        TreeNode temp = root;

        for(char c: word.toCharArray()) {
            if(temp.children[c -'a'] == null) {
                temp.children[c -'a'] = new TreeNode();
            }
            temp = temp.children[c-'a'];
        }
        temp.endOfWord = true;

    }

    public boolean search(String word) {
         TreeNode temp = root;
         for(char c: word.toCharArray()) {
            if(temp.children[c -'a'] != null) {
                temp = temp.children[c-'a'];
            } else {
                return false;
            }
            
        }
        return temp.endOfWord; 
    }

    public boolean startsWith(String prefix) {

        TreeNode temp = root;
         for(char c: prefix.toCharArray()) {
            if(temp.children[c -'a'] != null) {
                temp = temp.children[c-'a'];
            } else {
                return false;
            }
        }
        return true; 

    }
}
