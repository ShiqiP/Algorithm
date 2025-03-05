/**
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function (n) {
    let sameCol = 0;
    let sameDiagonal = 0;
    let sameAntiDiagonal = 0;
    let backtrack = (row) => {
        // base cases
        if (row === n) {
            return 1;
        }
        let ans = 0;
        for (let j = 0; j < n; j++) {
            const mask = 1 << j;
            const maskDiagonal = 1 << (row + j);
            const maskAntiDiagonal = 1 << (row - j + n);
            if (sameCol & mask || sameDiagonal & maskDiagonal || sameAntiDiagonal & maskAntiDiagonal) {
                continue;
            }
            // set visited
            sameCol |= mask;
            sameDiagonal |= maskDiagonal;
            sameAntiDiagonal |= maskAntiDiagonal;

            ans += backtrack(row + 1)

            // reset visited
            sameCol ^= mask;
            sameDiagonal ^= maskDiagonal;
            sameAntiDiagonal ^= maskAntiDiagonal;
        }
        return ans;
    }
    const ans = backtrack(0);
    return ans;
};