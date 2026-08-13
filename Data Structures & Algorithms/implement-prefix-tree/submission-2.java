class PrefixTree {
    Node root;
    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node tmp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (tmp.nei[index] == null) {
                tmp.nei[index] = new Node();
            }
            tmp = tmp.nei[index];
        }

        tmp.isWordEnd = true;
    }

    public boolean search(String word) {
        Node tmp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (tmp.nei[index] == null) return false;
            tmp = tmp.nei[index];
        }

        return tmp.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        Node tmp = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (tmp.nei[index] == null) return false;
            tmp = tmp.nei[index];
        }

        return true;
    }

    class Node {
        Node[] nei = new Node[26];
        boolean isWordEnd;
    }
}
