class Solution {
    public int subarraySum(int[] nums, int k) {
        //2, 1, 2, 4
    
        Map<Long, Integer> lastSeen = new HashMap<>();
        lastSeen.put(0l, 1);
        
        int i = 0;
        int result = 0;
        long pre = 0;

        while (i < nums.length) {
            pre += nums[i];
            long diff = pre - k;
            result += lastSeen.getOrDefault(diff, 0);
            lastSeen.put(pre, lastSeen.getOrDefault(pre, 0) + 1);
            i++;
        }

        return result;

    }
}