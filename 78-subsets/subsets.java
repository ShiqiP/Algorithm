class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, ans, 0);
        return ans;

    }

    public void backtrack(List<Integer> cur, int[] nums, List<List<Integer>> ans, int index) {
        if (index > nums.length) {
            return;
        }
        ans.add(new ArrayList<>(cur));

        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            // System.out.println("a" + index);
            backtrack(cur, nums, ans, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}