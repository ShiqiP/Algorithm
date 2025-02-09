/**
 * @param {number[][]} trips
 * @param {number} capacity
 * @return {boolean}
 */
var carPooling = function(trips, capacity) {
    let min = Infinity;
    let max = 0;
    let total = 0; // represents how many passengers are in the car
    for(let trip of trips){
        min = Math.min(trip[1], min);
        max = Math.max(trip[2], max);
    }
    // current location that the car is in
    for(let i = min; i <= max; i++){
        for(let j = 0; j < trips.length; j++){
            const trip = trips[j];
            const passengers = trip[0];
            const from = trip[1];
            const to = trip[2];
            if(i === from){
                total += passengers;
            }
            if(i === to){
                total -= passengers;
            }
        }
        if(total > capacity){
            return false;
        }
    }
    return true;
};