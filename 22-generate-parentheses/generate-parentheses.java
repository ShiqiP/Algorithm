class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(new StringBuilder(), n, n, 0, ans);
        return ans;
    }

    public void backtrack(StringBuilder cur, int left, int right, int remain, List<String> ans) {
        // bound condition
        if (left == 0 && right == 0) {
            ans.add(cur.toString());
            return;
        }

        // when we can choose right remain > 0
        // when we can choose left left > 0
        if (left > 0) {
            cur.append('(');
            backtrack(cur, left - 1, right, remain + 1, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (remain > 0) {
            cur.append(')');
            backtrack(cur, left, right - 1, remain - 1, ans);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}