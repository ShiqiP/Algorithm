class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // move the least frequnt element
        // map store the element and its frequency
        // element frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // min heap to store element but sort with the frequency of the element
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(map.get(a), map.get(b));
        });
        for (int key : map.keySet()) {
            heap.add(key);
        }

        // for k
        int i = 0;
        while (i < k) {
            int e = heap.remove();
            int f = map.get(e);
            // System.out.println("--------");
            // System.out.println(e);
            // System.out.println(f);
            if (i + f <= k) {
                map.remove(e);
            }
            i += f;
        }
        return map.size();
    }
}