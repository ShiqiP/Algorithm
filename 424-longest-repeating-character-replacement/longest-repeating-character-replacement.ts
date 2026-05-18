function characterReplacement(s: string, k: number): number {
    // slideing window
    // 1. record the maximum frequency of the valid window
    // 2. validation length of the window - maxFreq <= k
    // 3. break then start ++;
    // 4. ans = length of the valid window
    let maxFreq = 0;
    let freqMap = new Map<string, number>();
    let ans = 0;
    let l = 0, r = 0;
    while (l < s.length && r < s.length) {
        let curFreq = 1 + (freqMap.get(s[r]) || 0)
        freqMap.set(s[r], curFreq);
        // console.log(curFreq)
        maxFreq = Math.max(maxFreq, curFreq);

        while (r - l + 1 - maxFreq > k) {
            console.log(freqMap.get(s[l]) - 1)
            freqMap.set(s[l], freqMap.get(s[l]) - 1);
            l++;
        }

        ans = Math.max(ans, r - l + 1);
        r++;
    }
    return ans;
};