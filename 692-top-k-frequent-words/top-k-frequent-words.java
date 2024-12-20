class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // store the word and it's frequency
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if(map.get(s) == null){
                map.put(s,1);
            }else{
                map.put(s,map.get(s) + 1);
            }
        }

        // max heap to get the top k frequent words
        PriorityQueue<String> heap = new PriorityQueue<>((s1, s2) -> {
            if (map.get(s2) > map.get(s1)) {
                return 1;
            } else if (map.get(s2) < map.get(s1)) {
                return -1;
            } else {
                return s1.compareTo(s2);
            }
        });

        for(String s:map.keySet()){
            heap.add(s);
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(heap.remove());
        }
        return ans;
    }
}