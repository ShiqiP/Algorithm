class Solution {
    private Map<Integer, Integer> map;
    public Solution(){
        map = new HashMap<>();
    }
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if(map.containsKey(n)) return map.get(n);

        int ans = fib(n - 1) + fib(n - 2);
        map.put(n, ans);
        return ans;
    }

}