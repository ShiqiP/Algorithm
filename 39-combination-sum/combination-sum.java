class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(0, 0, new ArrayList<>(), candidates, target, ans);
        return ans;
    }

    public void backtracking(int sum, int index, List<Integer> cur, int[] candidates, int target,
            List<List<Integer>> ans) {
        
        int SUM = sum;
        if (SUM == target) {
            ans.add(new ArrayList<>(cur));
            return;
        }else if(SUM > target){
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int n = candidates[i];
            cur.add(n);
            SUM += n;
            backtracking(SUM,i,cur,candidates,target,ans);
            SUM -= cur.get(cur.size()-1);
            cur.remove(cur.size() - 1 );
        }
    }
}