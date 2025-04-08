function countComponents(n: number, edges: number[][]): number {
    let neiArr: number[][] = new Array(n).fill(0).map(() => new Array());
    let visited: boolean[] = new Array(n);
    let ans = 0;
    for (let edge of edges) {
        neiArr[edge[0]].push(edge[1]);
        neiArr[edge[1]].push(edge[0]);
    }
    //dfs
    let stack: number[] = [];
    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            stack.push(i)
            ans++
        };
        while (stack.length > 0) {
            const node = stack.pop();
            visited[node] = true;
            for (let nei of neiArr[node]) {
                if (!visited[nei])
                    stack.push(nei);
            }

        }
    }
    return ans;
};