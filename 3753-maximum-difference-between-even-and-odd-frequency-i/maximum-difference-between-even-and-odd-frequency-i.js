/**
 * @param {string} s
 * @return {number}
 */
var maxDifference = function (s) {
    let map = new Map();
    for (let i = 0; i < s.length; i++) {
        const c = s[i];
        map.get(c) ? map.set(c, map.get(c) + 1) : map.set(c, 1);
    }
    let maxOdd = 0;
    let minEven = s.length;
    console.log(map)
    Object.keys(map).forEach(key => {

    })
    for (let [key, freq] of map) {
        if (freq % 2 == 0) {
            minEven = Math.min(minEven, freq);
        } else {
            maxOdd = Math.max(maxOdd, freq);
        }
    }
    return maxOdd - minEven;
};