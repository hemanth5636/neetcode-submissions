class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.contains(num) && !set.contains(num - 1)) {
                int curResult = 1;
                int tmp = num;
                while (set.contains(tmp + 1)) {
                    tmp++;
                    curResult++;
                }
                result = Math.max(result, curResult);
            }
            seen.add(num);
        }
        
        return result;
    }
}
