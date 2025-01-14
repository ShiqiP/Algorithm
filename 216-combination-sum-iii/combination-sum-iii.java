class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, 0, new ArrayList<>(), k, n, ans);
        return ans;
    }

    public void backtrack(int index, int sum, List<Integer> cur, int k, int n, List<List<Integer>> ans) {
        if (cur.size() == k && sum == n) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < 10; i++) {
            if (sum + i <= n) {
                cur.add(i);
                backtrack(i + 1, sum + i, cur, k, n, ans);
                cur.remove(cur.size() - 1);
            }
        }
    }
}