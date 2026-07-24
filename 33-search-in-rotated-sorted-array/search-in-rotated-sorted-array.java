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
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                k = i+1;
            }
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid + "," + k);
            System.out.println(mid + k);
            int index = (mid + k ) % length;
            System.out.println(7 % 4);

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