class AuthenticationManager {

    int timeToLive;
    Deque<Pair<String, Integer>> queue;
    Map<String, Integer> map;
    // int total;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.queue = new LinkedList<>();
        this.map = new HashMap<>();
        // this.total = 0;

    }

    public void generate(String tokenId, int currentTime) {
        // store the tokenid and time
        // map token currentTime 
        queue.offer(new Pair<String, Integer>(tokenId, currentTime));
        this.map.put(tokenId, 1 + this.map.getOrDefault(tokenId, 0));
        // this.total ++;
    }

    public void renew(String tokenId, int currentTime) {
        // renew the unexpired token 
        // queue  {a:0},{b,2},{a,3}

        // poll the expired one 

        this.removeExpiredTokens(currentTime);
        if (this.map.containsKey(tokenId)) {
            this.generate(tokenId, currentTime);
        }

    }

    public int countUnexpiredTokens(int currentTime) {
        // count the unexpired token
        this.removeExpiredTokens(currentTime);

        // if there are several same tokenid in the queue. how to count 
        return this.map.size();
    }

    public void removeExpiredTokens(int currentTime) {
        while (!this.queue.isEmpty()) {
            int expiredTime = this.queue.peek().getValue() + this.timeToLive;
            if (expiredTime <= currentTime) {
                Pair<String, Integer> pair = this.queue.poll();
                String tokenId = pair.getKey();
                int freq = this.map.get(tokenId) - 1;
                if(freq == 0){
                    this.map.remove(tokenId);
                }else{
                    this.map.put(tokenId, freq);
                }
            } else {
                break;
            }
        }
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */