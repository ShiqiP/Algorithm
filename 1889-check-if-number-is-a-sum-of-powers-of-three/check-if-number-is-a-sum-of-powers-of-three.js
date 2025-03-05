/**
 * @param {number} n
 * @return {boolean}
 */
var checkPowersOfThree = function (n) {
    let power = 0;
    while (true) {
        if (n < Math.pow(3, power)) {
            break;
        }
        power++;
    }
    power--;
    while (n > 0 && power >= 0) {
        n -= Math.pow(3, power)
        if(n < 0){
            n += Math.pow(3, power)
        }
        power--;
    }
    return n === 0;
};