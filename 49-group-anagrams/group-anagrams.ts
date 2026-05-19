function groupAnagrams(strs: string[]): string[][] {
    // brute force
    /**
        two for loop
        first map to track the char and its frequency
        compare the ith str and the j str
     */
    let map = new Map<string, string[]>();

    // O(n)
    strs.forEach((el, index) => {
        // O(klogk)
        const formed = el.split("").sort().join();
        const arr = map.has(formed) ? [...map.get(formed), el] : [el];
        map.set(formed, arr);
        return [formed, el];
    }
    )
    let ans = [];
    map.forEach(el => ans.push(el));
    return ans;
};