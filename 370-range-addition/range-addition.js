/**
 * @param {number} length
 * @param {number[][]} updates
 * @return {number[]}
 */
var getModifiedArray = function(length, updates) {
    let arr = new Array(length).fill(0);
    for(let i = 0; i < updates.length; i++){
        const start = updates[i][0];
        const end = updates[i][1];
        const val = updates[i][2];

        arr[start] += val;
        if(end + 1 < length){
            arr[end + 1] -= val;
        }
    }
    let curVal = 0;
    for(let i = 0; i < length; i++){
        curVal += arr[i];
        arr[i] = curVal;
    }
    return arr;
};