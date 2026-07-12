class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int stairs = cost.length;
        int[] mincost = new int[stairs];

        // climb 1 or 2 steps
        // start with index 0 or 1
        mincost[0] = cost[0];
        mincost[1] = cost[1];

        for (int i = 2; i < stairs; i++) {
            mincost[i] = cost[i] + Math.min(mincost[i - 1], mincost[i - 2]);
        }

        return Math.min(mincost[stairs - 1], mincost[stairs - 2]);
    }
}