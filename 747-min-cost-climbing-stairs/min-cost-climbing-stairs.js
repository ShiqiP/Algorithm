/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function (cost) {

    // top-down
    let map = new Map();
    return DP(cost.length);

    function DP(floor) {

        if (floor == 0 || floor == 1) {
            return 0;
        }
        if(map.has(floor)){
            return map.get(floor);
        }
        map.set(floor,Math.min(DP(floor - 1) + cost[floor - 1], DP(floor - 2) + cost[floor - 2]));
        return map.get(floor);
    }

};