class Solution {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return result;    
    }

    private void backtrack(StringBuilder sb, int l, int r, int n) {
        if (sb.length() > n * 2) return;
        if (sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        }

        if (l < n) {
            sb.append("(");
            backtrack(sb, l + 1, r, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (r < l) {
            sb.append(")");
            backtrack(sb, l, r + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
