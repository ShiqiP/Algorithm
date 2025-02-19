/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
var getHappyString = function (n, k) {
    let total = 0;
    const letters = ['a', 'b', 'c'];
    let ans = "";
    backtrack([]);
    return ans;

    function backtrack(cur) {
        if (cur.length == n) {
            total++;
            return;
        }
        for (let l of letters) {
            if (cur.length != 0) {
                if (cur[cur.length - 1] == l) {
                    continue;
                }
            }
            cur.push(l);
            backtrack(cur);
            if (total == k) {
                const str = cur.join("");
                ans = str;
                return;
            }
            cur.pop();
        }
    }
};