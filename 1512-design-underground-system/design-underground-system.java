class UndergroundSystem {

    /**
        checkinMap
        id - stationName, t
    
        records
        start, end - sum of diff, times
     */
    Map<Integer, Pair<String, Integer>> checkinMap;
    Map<String, Pair<Integer, Integer>> records;

    public UndergroundSystem() {
        // 
        checkinMap = new HashMap<>();
        records = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        /**
        1. put value in checkinMap
         */
        checkinMap.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        /**
        1. get checkin record in checkinMap
        2. delete record in checkinMap
        3. put start-end, sum of diff, times in records
         */
        Pair<String, Integer> checkin = checkinMap.get(id);
        String key = checkin.getKey() + "-" + stationName;
        int diff = t - checkin.getValue();
        Pair<Integer, Integer> record = records.get(key);
        int sum = diff;
        int times = 1;
        if (record != null) {
            sum += record.getKey();
            times += record.getValue();
        }

        record = new Pair(sum, times);
        records.put(key, record);
    }

    public double getAverageTime(String startStation, String endStation) {
        /**
        1. concact the start-end
        2. find value in records
        3. calculate the average
        4. return
         */
        String key = startStation + "-" + endStation;
        Pair<Integer, Integer> record = records.get(key);
        double res = (double) record.getKey() / record.getValue();
        return res;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */