class Solution {
    public int singleNonDuplicate(int[] nums) {
        // bs
        // length of nums must be odd number
        // mid position of the nums
        // mid mid+1 mid-1
        // mid
        // 2 2 5 7 7 8 8 right = 6 mid = 3
        // 2 2 5 5 7 8 8 right = 6 mid = 3 left = 0
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid + 1 >= n || mid - 1 < 0)
                return nums[mid];
            if (nums[mid] == nums[mid - 1]) {
                if(right-left<3) return nums[mid+1];
                if ((mid - left+1) % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 2;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if(right-left<3) return nums[mid-1];
                if ((right - mid + 1) % 2 == 0) {
                    right = mid - 1;
                } else {
                    left = mid + 2;
                }
            } else {
                return nums[mid];
            }

        }
        return nums[right];
    }
}