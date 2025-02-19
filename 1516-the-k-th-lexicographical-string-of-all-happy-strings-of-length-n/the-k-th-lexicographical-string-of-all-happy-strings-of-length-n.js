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
        for (let i = 0; i < letters.length; i++) {
            const l = letters[i];
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