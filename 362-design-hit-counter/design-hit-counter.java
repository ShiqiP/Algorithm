class HitCounter {

    Queue<Integer> queue;
    public HitCounter() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.offer(timestamp);
    }   

    public int getHits(int timestamp) {
        // poll out the hit not in the timestamp
        while(queue.size() > 0){
            int diff = timestamp - queue.peek();
            if(diff >= 300){
                queue.poll();
            }else{
                break;
            }
        }
        // return the size of the queue
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */