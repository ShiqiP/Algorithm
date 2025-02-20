/**
 * @param {string[]} nums
 * @return {string}
 */
var findDifferentBinaryString = function (nums) {
    const len = nums[0].length;
    let backtrack = (cur) => {
        if (cur.length === len) {
            if (!nums.includes(cur.join(''))) {
                return cur.join('');
            }
            return ''
        }
        for (let i = 0; i <= 1; i++) {
            cur.push(i);
            let str = backtrack(cur);
            if (str !== '') {
                return str
            }
            cur.pop();
        }
        return ''
    }
    return backtrack([])
};