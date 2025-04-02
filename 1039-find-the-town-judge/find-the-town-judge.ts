function findJudge(n: number, trust: number[][]): number {
    let arr: number[][] = new Array(n + 1).fill(null).map(() => new Array(2).fill(0));
    //[in, out];
    for (let rel of trust) {
        arr[rel[0]][1]++;
        arr[rel[1]][0]++;
    }
    for (let i = 1; i <= n; i++) {
        const degree = arr[i];
        if (degree[0] === n - 1 && degree[1] === 0) {
            return i;
        }
    }
    return -1;
};