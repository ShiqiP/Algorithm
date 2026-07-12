class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int length = nums.length;
        int[] max = new int[length];

        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);
        int ans = max[1];

        for (int i = 2; i < length; i++) {
            // rob the current / no rob
            ans = Math.max(Math.max(nums[i] + max[i - 2], nums[i - 1]), ans);
            max[i] = ans;

        }

        return ans;
    }
}