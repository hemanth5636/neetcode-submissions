class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            if (Math.abs(l - r) <= k) {
                if (seen.contains(nums[r])) return true;
                seen.add(nums[r]);
            }

            if (Math.abs(l - r) == k) {
                seen.remove(nums[l++]);
            }

            r++;
        }

        return false;
    }
}