class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n, k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new ArrayList<>());
        return result;
    }

    private void backtrack(int index, List<Integer> curr) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (curr.size() > k) return;

        for (int i = index; i <= n; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}