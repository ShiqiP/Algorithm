class HitCounter {

    Deque<Pair<Integer, Integer>> queue;
    int total;

    public HitCounter() {
        queue = new LinkedList<>();
        total = 0;
    }

    public void hit(int timestamp) {
        if (queue.isEmpty() || queue.getLast().getKey() != timestamp) {
            queue.offer(new Pair(timestamp, 1));
        }else{
            int freq = 1 + queue.getLast().getValue();
            queue.removeLast();
            queue.offer(new Pair(timestamp, freq));
        }
        total++;
    }

    public int getHits(int timestamp) {
        // poll out the hit not in the timestamp
        while (queue.size() > 0) {
            int diff = timestamp - queue.peek().getKey();
            if (diff >= 300) {
                int freq = queue.poll().getValue();
                total -= freq;
            } else {
                break;
            }
        }
        // return the size of the queue
        return total;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */