function minWindow(s: string, t: string): string {
    // 1. sliding windows
    // 2. when reach to the substring has all the char in t shink
    // 3. ans minimun window substring of s

    let l = 0, r = 0;
    let tMap = new Map<string, number>();
    let sMap = new Map<string, number>();
    let required = 0;
    let formed = 0;
    let ans = new Array(2).fill(null);

    for (let i = 0; i < t.length; i++) {
        let freq = 1 + (tMap.get(t[i]) || 0);
        tMap.set(t[i], freq);
    }
    required = tMap.size;

    while (r < s.length) {
        let freq = 1 + (sMap.get(s[r]) || 0);
        sMap.set(s[r], freq);

        if(tMap.has(s[r]) && freq === tMap.get(s[r])){
            formed ++;
        }
        
        // valid 
        while (l <= r && required === formed) {

            if (ans[0] === null || (ans[1] - ans[0] > r - l)) {
                ans[0] = l;
                ans[1] = r;
            }

            sMap.set(s[l], sMap.get(s[l]) - 1);
            if(tMap.has(s[l]) && sMap.get(s[l]) < tMap.get(s[l])){
                formed--;
            }

            l++;
        }

        r++;
    }

    return ans[0] === null ? "" : s.substring(ans[0], ans[1] + 1);
};