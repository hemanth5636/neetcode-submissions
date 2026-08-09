class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }    
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.offer(val);
            pq.poll();
        }

        return pq.peek();
    }
}
