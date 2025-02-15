/**
 * @param {number[][]} trips
 * @param {number} capacity
 * @return {boolean}
 */
var carPooling = function(trips, capacity) {
    let arr = [];
    for(let i = 0; i < trips.length; i++){
        let trip = trips[i];
        arr.push([trip[1], trip[0]]);
        arr.push([trip[2], -trip[0]]);
    }
    arr.sort((a,b) => a[0] - b[0] || a[1] - b[1]);

    let curPassengers = 0;
    for(let i = 0; i < arr.length; i++){
        curPassengers += arr[i][1];
        if(curPassengers > capacity){
            return false;
        }
    }
    return true;
};