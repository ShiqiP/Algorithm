class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), n ,k,ans,1);
        return ans;
    }
    public void backtrack(List<Integer> curr, int n, int k,List<List<Integer>> ans ,int index){
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index; i <=n; i++){
            curr.add(i);
            backtrack(curr,n,k,ans,i+1);
            curr.remove(curr.size()-1);
        }
    }
}