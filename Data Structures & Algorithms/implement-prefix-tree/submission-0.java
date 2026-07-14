class PrefixTree {
    Node trie;
    public PrefixTree() {
         trie = new Node();
    }

    public void insert(String word) {
        Node tmp = trie;
        for (char w : word.toCharArray()) {
            int c = w - 'a';
            if (tmp.childs[c] == null) {
                tmp.childs[c] = new Node();
            }
            tmp = tmp.childs[c];
        }

        tmp.isWordEnding = true;
    }

    public boolean search(String word) {
        Node tmp = trie;
        for (char w : word.toCharArray()) {
            int c = w - 'a';
            if (tmp.childs[c] == null) return false;
            tmp = tmp.childs[c];
        }

        return tmp.isWordEnding;
    }

    public boolean startsWith(String prefix) {
        Node tmp = trie;
        for (char w : prefix.toCharArray()) {
            int c = w - 'a';
            if (tmp.childs[c] == null) return false;
            tmp = tmp.childs[c];
        }
        return true;
    }
}

class Node {
    Node[] childs = new Node[26];
    boolean isWordEnding = false;
}
