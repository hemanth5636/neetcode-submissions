class Solution {
    List<List<String>> result = new ArrayList<>();
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        backtrack(0, new ArrayList<>());
        return result;
    }

    private void backtrack(int i, List<String> curr) {
        if (i >= s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j)) {
                curr.add(s.substring(i, j+ 1));
                backtrack(j + 1, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        
        return true;
    }
}
