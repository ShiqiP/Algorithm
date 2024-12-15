class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(mid >= nums.length)
                return -1;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}