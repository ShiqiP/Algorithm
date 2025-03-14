/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function (chars) {
    let previous = chars[0];
    let count = 1;
    let pointer = 0;
    for (let i = 1; i < chars.length; i++) {
        if (chars[i] === previous) {
            count++;
        } else {
            chars[pointer++] = previous;
            if (count > 1) {
                let str = '' + count
                str.split('').forEach(n => {
                    chars[pointer++] = n + '';
                })
            }
            previous = chars[i];
            count = 1;
        }
    }
    chars[pointer++] = previous;
    if (count > 1) {
        let str = '' + count
        str.split('').forEach(n => {
            chars[pointer++] = n + '';
        })
    }
    return pointer;
};