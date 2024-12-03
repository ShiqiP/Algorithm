class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counts = new HashMap<>();
        for(int n : nums){
            counts.put(n,counts.getOrDefault(n,0)+1);
        }

        // configure the heap put number in the heap
        // but sorted by the frequency
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> counts.get(n1) - counts.get(n2));
        for(int n:counts.keySet()){
            heap.add(n);
            if(heap.size()>k){
                heap.remove();
            }
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = heap.remove();
        }
        return ans;
    }
}