class Solution {
    public int deleteAndEarn(int[] nums) {
        // map store the num - sum 
        // set store the unique num
        // total
        // max
        // traverse set
        /**
            2 delete 3s 4s
        
         */
        Map<Integer, Integer> map = new HashMap<>();
        int maxNumber = 0;

        for (int num : nums) {
            map.put(num, num + map.getOrDefault(num, 0));
            maxNumber = Math.max(maxNumber, num);
        }

        int[] maxPoints = new int[maxNumber + 1];
        maxPoints[1] = map.getOrDefault(1, 0);

        for(int i = 2; i <= maxNumber; i++){
            int gain = map.getOrDefault(i, 0);
            maxPoints[i] = Math.max(    
                maxPoints[i - 1],
                maxPoints[i - 2] + gain
            );
        }
        return maxPoints[maxNumber];
    }

}