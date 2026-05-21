function isValid(s: string): boolean {
    let stack = [];
    let num = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(' || s[i] === '{' || s[i] === '[') {
            stack.push(s[i]);
            num++;
        }
        if (s[i] === ')' && stack[stack.length - 1] === '(' || s[i] === '}' && stack[stack.length - 1] === '{' || s[i] === ']' && stack[stack.length - 1] === '[') { stack.pop(); num++; }
    }
    return num === s.length && stack.length === 0;
};