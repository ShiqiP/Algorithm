/**
 * @param {number[][]} grid
 * @return {number}
 */
var uniquePathsIII = function (grid) {
    let ans = 0;
    let startRow, startCol;
    let nonObstacles = 0;
    let m = grid.length, n = grid[0].length;
    let seen = Array.from({ length: m }, () => new Array(n).fill(false));
    const directions = [[1, 0], [0, 1], [-1, 0], [0, -1]];
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] !== -1) {
                nonObstacles++;
            }
            if (grid[i][j] === 1) {
                startRow = i;
                startCol = j;
            }
        }
    }
    seen[startRow][startCol] = true;
    backtrack([[startRow, startCol]], startRow, startCol);
    return ans;
    function backtrack(paths, row, col) {

        // reach the ending squres 
        // and have walked through all the non-obstacles squres
        if (grid[row][col] === 2 && paths.length === nonObstacles) {
            ans++;
            return;
        }
        for (let direction of directions) {
            const nextRow = row + direction[0];
            const nextCol = col + direction[1];

            paths.push([nextRow, nextCol]);
            seen[row][col] = true;

            if (valid(nextRow, nextCol)) {
                backtrack(paths, nextRow, nextCol);
            }
            seen[row][col] = false;
            paths.pop();
        }
    }
    function valid(row, col) {
        if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] != -1 && !seen[row][col]) {
            return true;
        }
        return false;
    }
};


// permutation-like problems & graph
// list all the posibilities of walking from starting to ending
// walk over every non-obstacles excatly once 