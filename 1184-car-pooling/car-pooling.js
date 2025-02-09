/**
 * @param {number[][]} trips
 * @param {number} capacity
 * @return {boolean}
 */
var carPooling = function(trips, capacity) {
    let max = 0;
    for(let trip of trips){
        max = Math.max(trip[2], max);
    }
    let arr = new Array(max + 1).fill(0);
    // current location that the car is in
    for(let i = 0; i < trips.length; i++){
        const num = trips[i][0];
        const from = trips[i][1];
        const to = trips[i][2];
        arr[from] += num;
        arr[to] -= num;
    }
    // passengers are accumulated
    let passengers = 0;
    for(let num of arr){
        passengers += num;
        if(passengers > capacity){
            return false;
        }
    }
    return true;
};