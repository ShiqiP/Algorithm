/**
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
var getHappyString = function (n, k) {
    let allArr = [];
    const letters = ['a', 'b', 'c'];
    backtrack([]);
    return k <= allArr.length ? allArr[k - 1] : "";

    function backtrack(cur) {
        if (cur.length == n) {
            const str = cur.join("");
            !allArr.includes(str) ? allArr.push(str) : "";
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
            cur.pop();
        }
    }
};