/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function (s) {
    // every integers is smaller than 256
    let ans = [];
    // list all the combination of dots which is an array length is 3
    // and check wether the dot position separate the string to a valid IP
    backtrack(0, [], s, ans);
    return ans;

    function backtrack(start, dots, s, ans) {
        if (start > s.length) return;
        if (dots.length == 3) {
            formIP(dots, s, ans);
            return;
        }
        // s.length - pos > remain;
        // cur - pre <3
        for (let i = start; i < s.length; i++) {
            const pre = dots.length == 0 ? 0 : dots[dots.length - 1];
            const cur = i;
            const remain = 3 - dots.length
            dots.push(cur);
            if ((s.length - cur) >= remain && (s.length - cur) <= (3 * remain) && (cur - pre) > 0 && (cur - pre) <= 3) {
                backtrack(i + 1, dots, s, ans)
            }
            dots.pop();
        }
    }
    function formIP(dots, s, ans) {
        let ip = "";
        let start = 0;
        for (let dot of [...dots,s.length]) {
            const num = s.substring(start, dot)
            if (num * 1 > 255 || (dot - start > 1 && s[start] == 0)) return;
            start = dot;
            ip += num + (dot != s.length ? "." : "");
        }
        ans.push(ip);
    }
};