class Solution {
    public int[] productExceptSelf(int[] nums) {
        // totalProduct except 0

        int[] ans = new int[nums.length];
        int totalProduct = 1;
        List<Integer> zeros = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                zeros.add(i);
            } else {
                totalProduct *= nums[i];

            }
        }
        if (zeros.size() > 1)
            return ans;
        if (zeros.size() == 1) {
            ans[zeros.get(0)] = totalProduct;
            return ans;
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = totalProduct / nums[i];
        }

        return ans;

    }
}