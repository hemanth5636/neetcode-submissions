class Solution {
    HashSet<String> seen = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
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

        for (int i = index; i < nums.length; i++) {
            if (nums[i] + curr > target) break;
            
            list.add(nums[i]);
            backtrack(nums, i, curr + nums[i], target, list, result);
            list.remove(list.size() - 1);
        }
    }
}

