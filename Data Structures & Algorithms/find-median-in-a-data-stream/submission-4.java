class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        min.offer(num);
        max.offer(min.poll());
        if (max.size() > min.size()) {
            min.offer(max.poll());
        }
    }
    
    public double findMedian() {
        if (min.size() > max.size()) return min.peek();
        return (min.peek() + max.peek()) / 2.0;
    }
}
