function threeSum(nums: number[]): number[][] {
    // two pointer and one fixed
    let dups = new Set<number>();
    let seen = new Map<number, number>();
    let res = new Set<string>();
    let i = 0;
    while(i < nums.length){
        if(dups.has(nums[i])) {
            i++;
            continue;
        }
        dups.add(nums[i]);
        let j = i + 1;
        while(j < nums.length){
            const complement = -nums[i] - nums[j];
            if(seen.has(complement) && seen.get(complement) === i){
                res.add(JSON.stringify([complement, nums[i],nums[j]].sort()));
            }
            seen.set(nums[j], i);
            j++;
        }
        i++;
    }
    return Array.from(res).map(el => JSON.parse(el));
};