class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int length = nums.length;
        int[] max = new int[length + 1];

        max[length] = 0;
        max[length - 1] = nums[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            // rob the current / no rob
            max[i] = Math.max(max[i+1], max[i+2] + nums[i]);

        }

        return max[0];
    }
}