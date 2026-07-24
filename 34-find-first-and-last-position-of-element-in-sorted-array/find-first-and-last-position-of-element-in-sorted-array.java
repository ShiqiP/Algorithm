class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] { -1, -1 };

        // find the left most;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                ans[0] = mid;
                right = mid - 1;
            }
        }

        if (ans[0] == -1)
            return ans;
        // find the right most;
        left = 0;
        right = nums.length - 1;


        while (left <= right) {
            int mid = (right + left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                ans[1] = mid;
                left = mid + 1;
            }
        }

        return ans;

    }
}