/**
 * @param {number} n
 * @param {number} index
 * @param {number} maxSum
 * @return {number}
 */
var maxValue = function (n, index, maxSum) {
    function getSum(value, index, maxSum) {
        let sum = 0;
        // 1  5
        // 1 1 2
        if (value > index) {
            sum += (value + value - index) * (index + 1) / 2;
        } else {
            sum += (value + 1) * value / 2 + index - value + 1;
        }

        if (value >= n - index) {
            sum += (value + value - n + 1 + index) * (n - index) / 2;
        } else {
            sum += (value + 1) * value / 2 + n - index - value;
        }
        return sum - value <= maxSum;
    }

    let left = 1, right = maxSum;
    while (left < right) {
        let mid = Math.floor((left + right + 1) / 2);
        if (getSum(mid, index, maxSum)) {
            left = mid;
        } else {
            right = mid - 1;
        }
    }
    return left;
};