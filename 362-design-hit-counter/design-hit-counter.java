class HitCounter {
    Map<Integer, Integer> map;

    public HitCounter() {
        // ascending map 
        this.map = new TreeMap<>();
    }

    public void hit(int timestamp) {
        // store the hit timestamp
        // data structure 
        // int []
        // map timestamp - number
        // arr,  map, 
        int number = 1 + this.map.getOrDefault(timestamp, 0);
        this.map.put(timestamp, number);
    }   

    public int getHits(int timestamp) {
        /**
        1. calculate time frame (timestamp - 300, timestamp)
        2. retrive the number of hit within this timeframe
        3. for from start to end  O(n);
         */
        
        int start = Math.max(0, timestamp - 300); // not included
        int end = timestamp;

        int count = 0;

        for(int t : this.map.keySet()){
            if( t > start && t <= end){
                count += this.map.get(t);
            }
        }
        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */