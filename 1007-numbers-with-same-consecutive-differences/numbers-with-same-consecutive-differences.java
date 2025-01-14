class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> ans = new HashSet<>();
        for(int i=1; i<10; i++){
            backtrack(i,n,k,ans);
        }
        int[] result = ans.stream().mapToInt(i->i).toArray();
        return result;
    }

    public void backtrack(int cur, int n, int k, Set<Integer> ans) {
        if (cur / (int)Math.pow(10, n - 1) > 0) {
            ans.add(cur);
            return;
        }
        // low digit + k < 10
        // low digit - k > 0
        int low = cur % 10;
        if(low + k < 10){
            backtrack(cur*10 + low + k,n,k,ans);
        }
        if(low - k >= 0){
            backtrack(cur*10 + low - k,n,k,ans);
        }
    }
}