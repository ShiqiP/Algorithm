/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function (intervals) {
    intervals.sort((a, b) => a[0] - b[0]);
    let ans = [];
    ans.push(intervals[0]);
    let i = 1;
    while (i < intervals.length) {
        if (ans[ans.length - 1][1] >= intervals[i][0]) {
            ans[ans.length - 1][1] = Math.max(ans[ans.length - 1][1] ,intervals[i][1]);
            i++;
        } else {
            ans.push(intervals[i]);
        }
    }
    return ans;
};