function topKFrequent(nums: number[], k: number): number[] {
    let map = new Map<number, number>();
    for (let el of nums) {
        map.set(el, 1 + map.get(el) || 1);
    }
    const arr = Array.from(map).sort((a,b) => b[1] - a[1])
    let ans = [];
    for(let i = 0; i < k; i++){
        ans.push(arr[i][0]);
    }
    return ans;
};