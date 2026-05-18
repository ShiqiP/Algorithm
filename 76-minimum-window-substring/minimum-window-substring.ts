function minWindow(s: string, t: string): string {
    // 1. sliding windows
    // 2. when reach to the substring has all the char in t shink
    // 3. ans minimun window substring of s

    let l = 0, r = 0;
    let tMap = new Map<string, number>();
    let sMap = new Map<string, number>();
    let valid = false;
    for (let i = 0; i < t.length; i++) {
        let freq = 1 + (tMap.get(t[i]) || 0);
        tMap.set(t[i], freq);
    }
    let ans = new Array(2).fill(null);
    while (r < s.length) {
        let freq = 1 + (sMap.get(s[r]) || 0);
        sMap.set(s[r], freq);

        while (isValid(sMap, tMap)) {
            if (valid === false || (ans[1] - ans[0] > r - l)) {
                ans[0] = l;
                ans[1] = r;
            }
            valid = true;
            sMap.set(s[l], sMap.get(s[l]) - 1);
            l++;
        }

        r++;
    }
    function isValid(aMap, bMap): boolean {
        let valid = true;
        for (const key of bMap.keys()) {
            if (!aMap.get(key) || aMap.get(key) < bMap.get(key)) {
                valid = false;
                break;
            }
        }
        return valid;
    }
    return ans[0] === null ? "" : s.substring(ans[0], ans[1] + 1);
};