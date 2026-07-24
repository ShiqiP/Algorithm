class Solution {
    public int search(int[] nums, int target) {
        // length 8  k = 3
        // 8 % (0 + 3 + 1; = 4
        // 8 % (1 + 3 + 1; = 5
        // 8 % (2 + 3 + 1; = 6
        // 8 % (4 + 3 + 1; = 0

        int left = 0;
        int right = nums.length - 1;
        int length = nums.length;
        int k = 0;

    // Step 1: Find the index of the minimum element (pivot)
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
         k = left; // index of smallest element

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int index = (mid + k) % length;

            if (nums[index] == target)
                return index;

            if (nums[index] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}