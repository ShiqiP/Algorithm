function trap(height: number[]): number {
    // brute force solution
    // left el right 
    const n = height.length;
    let ans = 0;
    // Math.min(left, right) - height[i]
    // 1. iterate height
    // need to be in the middle to store water
    for (let i = 1; i < n; i++) {
        let leftMax = 0, rightMax = 0;
        // find the leftMax, rightMax
        for (let j = i; j >= 0; j--) {
            leftMax = Math.max(height[j], leftMax);
        }
        for(let k = i; k < n; k++){
            rightMax = Math.max(height[k], rightMax);
        }
        // calculate the water of each position
        // only store the water of the minimum height
        ans += Math.min(leftMax, rightMax) - height[i];
    }
    return ans;
}