class Leaderboard {

    // List<>
    // map variable to store the playerid score 
    // top k monontonic stack / max heap

    Map<Integer, Integer> map;

    public Leaderboard() {
        // max 
        this.map = new TreeMap<>();

    }

    public void addScore(int playerId, int score) {
        this.map.put(playerId, score + this.map.getOrDefault(playerId, 0));
    }

    public int top(int K) {
        int ans = 0;
        int count = 0;
        System.out.println(map);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort the list using a custom Comparator
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<Integer, Integer> entry : list) {
            if (count < K) {
                ans += entry.getValue();
                count++;
            }
        }
        return ans;
    }

    public void reset(int playerId) {
        map.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */