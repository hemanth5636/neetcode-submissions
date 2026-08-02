class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        int result = 0;

        for (int num : nums) {
            if (set.contains(num - 1)) continue;

            int curr = num;
            while (set.contains(curr + 1)) {
                curr++;
            }

            result = Math.max(result, curr - num + 1);
        }   

        return result;
    }
}
