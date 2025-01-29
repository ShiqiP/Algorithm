/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function (s) {
    let l = 0, r = s.length - 1;
    const vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
    const ans = s.split('');
    while (l < r) {
        if (vowels.includes(ans[l]) && vowels.includes(ans[r])) {
            const temp = ans[l];
            ans[l] = ans[r];
            ans[r] = temp;
            l++;
            r--;
            continue;
        }
        if (vowels.includes(ans[l])) {
            r--;
            continue;
        }
        if (vowels.includes(ans[r])) {
            l++;
            continue;
        }
        r--;
        l++;
    }
    return ans.join('');
};