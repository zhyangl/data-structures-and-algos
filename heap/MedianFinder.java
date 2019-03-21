/* 注意cast to double
 * 两个heap，minHeap存大的一半，maxHeap存小的一半，maxHeap的size永远比minHeap大1
 */

class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    
        
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    // max heap : 2 1
    // min heap : 3 4
    
    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            // if bigger than the smallest value in minHeap (the big part)
            // -> move the smallest value in big part to the small part(maxHeap)
            if (minHeap.peek() != null && num > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
            }
        } else {
            // if smaller than the largest value in maxHeap (the small part)
            // -> move the largest value in small part to the big part(minHeap)
            if (maxHeap.peek() != null && num < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            // System.out.println(maxHeap.peek() + " " + minHeap.peek() );
            return (double) (maxHeap.peek() + minHeap.peek())/2;
        }
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
