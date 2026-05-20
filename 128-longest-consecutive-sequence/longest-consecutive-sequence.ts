function longestConsecutive(nums: number[]): number {
    // set 
    // find the beginneing of the consecutive sequence
    // num ++ in the set
    let set = new Set<number>(nums);
    let ans = 0;
    for(let el of set){
        if(!set.has(el - 1)){
            let streak = 1
            let num = el;
            while(set.has(num + 1)){
                streak++;
                num++;
            }
            ans = Math.max(ans, streak);
        }
    }
    return ans;
};