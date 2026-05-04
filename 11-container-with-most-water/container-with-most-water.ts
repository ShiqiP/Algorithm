function maxArea(height: number[]): number {
    
    // brute force
    let ans = 0;
    // for(let i = 0; i < height.length; i++){
    //     for(let j = i + 1; j < height.length; j++){
    //         let h = Math.min(height[i], height[j]);
    //         let w = j - i;
    //         ans = Math.max(ans, h * w);
    //     }
    // }
    // return ans;
    let left:number = 0;
    let right:number = height.length - 1;
    while(left < right){
        let h:number = Math.min(height[left], height[right]);
        let w:number = right - left;
        ans = Math.max(ans, h * w);
        if(height[left] <= height[right]){
            left ++;
        }else{
            right --;
        }
    }
    console.log(ans)
    return ans;
    // ans = height * width (maxs)
    // height = min(h(ib), h(ia))
    // width = ib - ia
};