class Solution {
    public int findMin(int[] nums) {
        // divide and conquer
        int len = nums.length;
        if(nums.length == 0) return Integer.MAX_VALUE;
        if (len == 1)
            return nums[0];
        if (len == 2)
            return nums[0] < nums[1] ? nums[0] : nums[1];

        int mid = (len) / 2;
        // System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, mid)));
        int min = Math.min(findMin(Arrays.copyOfRange(nums, 0, mid + 1)), findMin(Arrays.copyOfRange(nums, mid + 1, len)));
        return min;

    }
}