class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(0, 0, new ArrayList<>(), candidates, target, ans);
        return ans;
    }

    public void backtracking(int sum, int index, List<Integer> cur, int[] candidates, int target,
            List<List<Integer>> ans) {
        
        if (sum == target) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int n = candidates[i];
            if(sum + n <= target){
                cur.add(n);
                backtracking(sum + n,i,cur,candidates,target,ans);
                cur.remove(cur.size() - 1 );
            }

        }
    }
}