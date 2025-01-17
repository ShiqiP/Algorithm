class Solution {
    int[] dist;
    int min_unfairness;
    public int distributeCookies(int[] cookies, int k) {
       dist = new int[k];
       min_unfairness = Integer.MAX_VALUE;
       backtrack(0,cookies,k);
       return min_unfairness;
    }
    public void backtrack(int i,int[] cookies,int k){
        if(i == cookies.length){
            min_unfairness = Math.min(min_unfairness,Arrays.stream(dist).max().getAsInt());
            return;
        }
        if(min_unfairness <= Arrays.stream(dist).max().getAsInt()){
            return;
        }
        // all the posibility 
        // find the max sum 
        for(int z=0; z<k;z++){
            dist[z] += cookies[i];
            backtrack(i+1,cookies,k);
            dist[z] -= cookies[i];
        }
    }
}