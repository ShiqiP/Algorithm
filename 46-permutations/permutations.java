class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {

        backtrack(new ArrayList<>(), nums);

        return ans;
    }
    public void backtrack(List<Integer> curr, int[] nums){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            curr.add(nums[i]);
            backtrack(curr, nums);
            curr.remove(curr.size() - 1);
            set.remove(nums[i]);
        }
    }
}   