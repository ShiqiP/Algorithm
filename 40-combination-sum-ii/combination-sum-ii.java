class Solution {
    Set<Integer> set;
    int sum;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        this.set = new HashSet<>();
        backtracking(0, new ArrayList<>(), 0, candidates, target, ans);
        return ans;
    }

    public void backtracking(int index, List<Integer> cur, int sum, int[] candidates, int target,
            List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            boolean seen = false;
            for (int j = 0; j < i; j++) {
                if (candidates[j] == candidates[i] && !set.contains(j))
                    seen = true;
            }
            if (sum + candidates[i] <= target && !seen) {
                cur.add(candidates[i]);
                set.add(i);
                backtracking(i + 1, cur, sum + candidates[i], candidates, target, ans);
                cur.remove(cur.size() - 1);
                set.remove(i);
            }
        }
    }
}