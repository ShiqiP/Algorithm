/**
 * @param {number} n
 * @param {number[][]} lights
 * @param {number[]} requirement
 * @return {number}
 */
var meetRequirement = function (n, lights, requirement) {
    let position = new Array(n + 1).fill(0);
    for (let light of lights) {
        const left = Math.max(0, light[0] - light[1]);
        const right = Math.min(n - 1, light[0] + light[1]);
        position[left]++;
        position[right + 1]--;
    }
    let ans = 0;
    let accumulate = 0;
    position.forEach((el, i) => {
        accumulate += el;
        if (accumulate >= requirement[i]) {
            ans++;
        }
    })
    return ans;
};