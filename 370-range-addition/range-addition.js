/**
 * @param {number} length
 * @param {number[][]} updates
 * @return {number[]}
 */
var getModifiedArray = function(length, updates) {
    let arr = new Array(length).fill(0); // edge-value
    for(let i = 0; i < updates.length; i++){
        const start = updates[i][0];
        const end = updates[i][1];
        const value = updates[i][2];
        for(let i = start; i <= end; i++){
            arr[i] += value;
        }
    }
    return arr;
};