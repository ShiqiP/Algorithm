/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    let ans = 0;
    let m = grid.length;
    let n = grid[0].length;
    // graph 
    for(let r=0; r < m; r++){
        for(let c=0; c<n; c++){
            if(grid[r][c] === '1') {
                dfs(r, c);
                ans++;
            }
        }
    }
    // dfs
    function dfs(r, c){
        if(r < 0 || c < 0 || r>= m || c >=n || grid[r][c] === '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(r + 1, c);
        dfs(r - 1, c);
        dfs(r, c - 1);
        dfs(r, c + 1);
    }

    // 
    return ans;
};