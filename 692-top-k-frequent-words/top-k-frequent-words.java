class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // store the word and it's frequency
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            // System.out.println(i);
            String s = words[i];
            if(map.get(s) == null){
                map.put(s,1);
                list.add(i);
            }else{
                map.put(s,map.get(s) + 1);
            }
        }

        // max heap to get the top k frequent words
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> {
            if (map.get(words[n2]) > map.get(words[n1])) {
                return 1;
            } else if (map.get(words[n2]) < map.get(words[n1])) {
                return -1;
            } else {
                return words[n1].compareTo(words[n2]);
            }
        });

        for(Integer n:list){
            heap.add(n);
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int temp = heap.remove();
            ans.add(words[temp]);
        }
        return ans;
    }
}