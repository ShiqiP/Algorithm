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
            if (checkVerified(row, j)) {
                setVisited(row, j)
                ans += backtrack(row + 1)
                resetVisited(row, j);
            }
        }
        return ans;
    }
    let checkVerified = (row, col) => {
        // 0000
        // 0001
        const mask = 1 << col;
        const maskDiagonal = 1 << (row + col);
        const maskAntiDiagonal = 1 << (row - col + n);
        // same col
        return ((sameCol & mask) === 0 &&
            // diaganal i + j 
            (sameDiagonal & maskDiagonal) === 0 &&
            // antiDiagonal i - j
            (sameAntiDiagonal & maskAntiDiagonal) === 0);
    }
    let setVisited = (row, col) => {
        const mask = 1 << col;
        const maskDiagonal = 1 << (row + col);
        const maskAntiDiagonal = 1 << (row - col + n);
        sameCol |= mask;
        sameDiagonal |= maskDiagonal;
        sameAntiDiagonal |= maskAntiDiagonal;
    }
    let resetVisited = (row, col) => {
        const mask = 1 << col;
        const maskDiagonal = 1 << (row + col);
        const maskAntiDiagonal = 1 << (row - col + n);
        sameCol ^= mask;
        sameDiagonal ^= maskDiagonal;
        sameAntiDiagonal ^= maskAntiDiagonal;
    }
    const ans = backtrack(0);
    return ans;
};