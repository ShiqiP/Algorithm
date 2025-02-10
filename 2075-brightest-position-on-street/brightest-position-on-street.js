/**
 * @param {number[][]} lights
 * @return {number}
 */
var brightestPosition = function (lights) {
    let arr = [];
    for (let light of lights) {
        let left = light[0] - light[1];
        let right = light[0] + light[1];
        arr.push([left, 1]);
        arr.push([right + 1, -1]);
    }
    arr.sort((a, b) => a[0] - b[0] || a[1] - b[1]);
    let brightest = 0;
    let position = 0;
    let cur = 0;
    for (const [pos, value] of arr) {
        cur += value;
        if (cur > brightest) {
            position = pos;
            brightest = cur;
        }
    }
    return position;
};