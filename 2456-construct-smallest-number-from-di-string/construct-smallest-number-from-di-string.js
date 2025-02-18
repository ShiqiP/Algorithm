/**
 * @param {string} pattern
 * @return {string}
 */
var smallestNumber = function (pattern) {
    const n = pattern.length; // 3
    //ascending 01234
    let store = new Array(n + 2).fill(1);
    let ans = [];
    let backtrack = (index, pre) => {
        if (index >= n) {
            return true;
        }
        // IIIDIDDD
        //123549876
        for (let i = index; i < n; i++) {
            if (pattern[i] === 'I') {
                for (let j = pre + 1; j < store.length; j++) {
                    if (store[j] > 0) {
                        ans.push(j);
                        store[j]--;
                        if (backtrack(i + 1, j)) {
                            return true;
                        } else {
                            ans.pop();
                            store[j]++;
                        }
                    }
                }
            } else {
                for (let j = pre - 1; j >= 1; j--) {
                    if (store[j] > 0) {
                        ans.push(j);
                        store[j]--;
                        if (backtrack(i + 1, j)) {
                            return true;
                        } else {
                            ans.pop();
                            store[j]++;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }
    for (let i = 1; i <= n + 1; i++) {
        ans.push(i);
        store[i]--;
        if (backtrack(0, i)) {
            break;
        }
        store[i]++;
        ans.pop();
    }

    return ans.join('');
};