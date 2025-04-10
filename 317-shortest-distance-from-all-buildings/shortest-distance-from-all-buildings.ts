function shortestDistance(grid: number[][]): number {
    const m = grid.length;
    const n = grid[0].length;
    const directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    let ans = Infinity;
    let ones = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] === 1) ones++;
        }
    }
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] == 0) {
                grid[i][j] = 1;
                // console.log("------")
                // console.log(i, j)
                const curTotal = totalDistance(i, j, ones)
                // console.log(curTotal)
                ans = Math.min(ans, curTotal === -1 ? ans : curTotal);
                grid[i][j] = 0;
            }
        }
    }

    return ans === Infinity ? -1 : ans;
    function totalDistance(i: number, j: number, ones: number): number {
        let queue = [];
        let visited: boolean[][] = new Array(m).fill(0).map(() => new Array(n).fill(false));
        queue.push([i, j, 0])
        let sum = 0; // 1
        let total = 0;
        while (queue.length > 0) {
            const [row, col, dis] = queue.shift();
            visited[row][col] = true;
            for (let direc of directions) {
                const nextRow = row + direc[0];
                const nextCol = col + direc[1];
                if (checkNode(nextRow, nextCol, visited)) {
                    if (grid[nextRow][nextCol] === 0) {
                        visited[nextRow][nextCol] = true;
                        queue.push([nextRow, nextCol, dis + 1]);
                    }
                    else if (grid[nextRow][nextCol] === 1) {
                        // console.log(nextRow, nextCol, dis)
                        visited[nextRow][nextCol] = true;
                        sum += dis + 1;
                        total++;
                    }
                }
            }
        }
        // console.log("----")
        // console.log(sum)
        // console.log(i, j)
        // console.log(ones, total)
        return total === ones ? sum : -1;
    }
    function checkNode(i: number, j: number, visited: boolean[][]) {
        return i >= 0 && i < m && j >= 0 && j < n && !visited[i][j];
    }

};