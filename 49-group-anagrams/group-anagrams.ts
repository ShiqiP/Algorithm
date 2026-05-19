function groupAnagrams(strs: string[]): string[][] {
    // brute force
    /**
        two for loop
        first map to track the char and its frequency
        compare the ith str and the j str
     */
    let map = new Map<string, string[]>();
    strs.forEach((el, index) => {
        const formed = el.split("").sort((a, b) => { return a.charCodeAt(0) - b.charCodeAt(0) }).join("")
        const arr = map.has(formed) ? [...map.get(formed), el] : [el];
        map.set(formed, arr);
        return [formed, el];
    }
    )
    let ans = [];
    map.forEach(el => ans.push(el));
    return ans;
};