/**
 * @param {number} length
 * @param {number[][]} updates
 * @return {number[]}
 */
var getModifiedArray = function(length, updates) {
    let arr = new Array(length).fill(0); // edge-value
    let ans = new Array(length);
    let preValue = 0;
    let startIndex = -1;
    let endIndex = -1;
    for(let i = 0; i < updates.length; i++){
        const start = updates[i][0];
        const end = updates[i][1];
        const value = updates[i][2];
        for(let i = start; i <= end; i++){
            arr[i] += value;
        }
        // arr[start] += value;
        // arr[end] += value;
        // for(let i = Math.max(start,startIndex); i<= Math.min(end,endIndex); i++){
        //     console.log(preValue)
        //     arr[i] += preValue;
        // }
        // console.log(arr)
        // startIndex = start;
        // endIndex = end;
        // preValue = value;
    }
    // console.log(arr)
    // let accumulation = 0;
    // for(let i = 0; i < arr.length; i++){
    //     accumulation += arr[i];
    //     ans[i] = accumulation;
    // }
    return arr;
};