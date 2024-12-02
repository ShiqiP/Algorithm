class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        double target = 0;
        int ans = 0;
        for(double n:nums){
            heap.add(n);
            sum += n;
        }
        target = sum /2;
        
        while(sum > target){
            ans ++;
            double max = heap.remove();
            sum -= max/2;
            heap.add(max/2);
        }
        return ans;
    }
}