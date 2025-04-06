function equalSubstring(s: string, t: string, maxCost: number): number {
    let left = 0;
    const n = s.length;
    let max = 0;
    let sum = 0;
    let diffArr = new Array(n);
    for(let right = 0; right < n; right++){
        diffArr[right] = Math.abs(s[right].charCodeAt(0) - t[right].charCodeAt(0));
        sum += diffArr[right];
        while(sum > maxCost){
            sum -= diffArr[left];
            left++;
        }
        max = Math.max(max, right - left + 1);
    }
    return max;
};