class Solution {
    Map<Integer,Integer> map;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        backtrack(new ArrayList<>(), nums, ans);
        return ans;
    }

    public void backtrack(List<Integer> cur, int[] nums, List<List<Integer>> ans) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();

            if(count == 0) continue;

            cur.add(num);
            map.put(num,count-1);
            backtrack(cur,nums,ans);
            cur.removeLast();
            map.put(num,count);
        }
    }
}