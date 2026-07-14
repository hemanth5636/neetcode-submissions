class WordDictionary {

    TrieNode dict;

    public WordDictionary() {
        this.dict = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode tmp = dict;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (tmp.childs[index] == null)
                tmp.childs[index] = new TrieNode();
            tmp = tmp.childs[index];
        }

        tmp.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, dict);
    }

    private boolean dfs(String word, int index, TrieNode root) {
        if (index == word.length() && root.isEndOfWord) return true;

        if (index == word.length()) return false;

        char c = word.charAt(index);

        if (c != '.') {
            if (root.childs[c - 'a'] == null) return false;
            return dfs(word, index + 1, root.childs[c - 'a']);
        } else {
            for (int i = 0; i < 26; i++) {
                if (root.childs[i] != null && dfs(word, index + 1, root.childs[i])) {
                    return true;
                }
            }
        }

        return false;
    }

    class TrieNode {
        TrieNode[] childs = new TrieNode[26];
        boolean isEndOfWord = false;
    }
}
