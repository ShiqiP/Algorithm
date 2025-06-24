/**
 * @param {number[]} bulbs
 * @param {number} k
 * @return {number}
 */
var kEmptySlots = function (bulbs, k) {

    // ans day number range 1 - len
    // rule
    // 2 turned on bulbs that have k bulbs between them
    // k = 1  [1,0,1]
    // k = 2  [1,0,0,1]
    // deque
    // 1 3   cur - pre + 1 === k return day 
    // O(n)
    // map
    const n = bulbs.length;
    let lightArr = new Array(n + 1).fill(false)

    for (let day = 0; day < n; day++) {
        const bulbIndex = bulbs[day];
        const preTargetIndex = bulbIndex - k - 1;
        const postTargetIndex = bulbIndex + k + 1;
        lightArr[bulbIndex] = true;
        if (preTargetIndex > 0 && lightArr[preTargetIndex]) {
            let flag = true;
            for (let i = preTargetIndex + 1; i < bulbIndex; i++) {
                if (lightArr[i]) flag = false;
            }
            if (flag) return day + 1;
        }
        if (postTargetIndex < n + 1 && lightArr[postTargetIndex]) {
            let flag = true;
            for (let i = bulbIndex + 1; i < postTargetIndex; i++) {
                if (lightArr[i]) flag = false;
            }
            if (flag) return day + 1;
        }
    }
    return -1;
};