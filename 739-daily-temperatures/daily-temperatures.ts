function dailyTemperatures(temperatures: number[]): number[] {
    // min monotonic stack
    let stack: number[] = [];
    let ans: number[] = new Array(temperatures.length).fill(0);

    for (let i = 0; i < temperatures.length; i++) {
        while (stack.length > 0 && temperatures[i] > temperatures[stack[stack.length - 1]]) {
            const index = stack.pop();
            ans[index] = i - index;
        }
        stack.push(i);
    }
    return ans;
};