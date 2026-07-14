class Solution {
    HashSet<String> seen = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(
        int[] nums,
        int index, 
        int curr, 
        int target, 
        List<Integer> list, 
        List<List<Integer>> result
        ) {
        
        if (curr == target) {
            StringBuilder sb = new StringBuilder();
            for (int num : list) sb.append(num).append('-');
            if (!seen.contains(sb.toString())) {
                result.add(new ArrayList<>(list));
                seen.add(sb.toString());
            }
            
            return;
        }

        if (index >= nums.length || curr > target) return;

        backtrack(nums, index + 1, curr, target, list, result);
        
        list.add(nums[index]);
        backtrack(nums, index, curr + nums[index], target, list, result);
        list.remove(list.size() - 1);
    }
}

