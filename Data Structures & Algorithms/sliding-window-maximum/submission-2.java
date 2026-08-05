class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> monotonicQueue = new ArrayDeque<>();
        int l = 0;
        int r = 0;
        int resultIndex = 0;

        while (r < nums.length) {

            if (r - l + 1 > k) {
                if (l == monotonicQueue.peekFirst()) monotonicQueue.pollFirst();
                l++;
            }

            while (!monotonicQueue.isEmpty() &&
                    nums[r] > nums[monotonicQueue.peekLast()]) {
                        monotonicQueue.pollLast();
                    }

            monotonicQueue.offerLast(r);

            if (r - l + 1 == k) {
                result[resultIndex++] = nums[monotonicQueue.peekFirst()];
            }

            r++;

        }

        return result;
    }
}
