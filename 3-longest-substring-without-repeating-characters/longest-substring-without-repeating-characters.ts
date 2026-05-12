function lengthOfLongestSubstring(s: string): number {
    // map char-char index  
    let left = 0, right = 0;
    let longestLen = 0;
    let map = new Map<string, number>();
    /*     left right len
    a - 0  0    0
    b - 1  0    1 
    b - 2  2    2
    a - 
    */
    while (left < s.length && right < s.length) {
        if (map.has(s[right])) {
            left = Math.max(left, map.get(s[right]) + 1);
        }
        map.set(s[right], right);
        longestLen = Math.max(longestLen, right - left + 1);
        right++;
    }
    return longestLen;
};