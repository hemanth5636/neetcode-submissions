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
        // System.out.println(min + " min");
        // System.out.println(max + " max");
        if (min.isEmpty() && max.isEmpty()) return 0.0;

        if (min.size() == max.size()) {
            return ((double) min.peek() + (double) max.peek()) / (double)2;
        }

        return min.peek();
    }
}
