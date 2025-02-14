/**
 * @param {number[][]} logs
 * @return {number}
 */
var maximumPopulation = function(logs) {
    let arr = []; // year, value birth 1 , death -1
    for(let i = 0; i < logs.length; i++){
        arr.push([logs[i][0], 1]);
        arr.push([logs[i][1], -1]);
    }
    let population = 0;
    let maxPopulation = 0;
    let ans = 0;
    arr.sort((a,b) => a[0] - b[0] || a[1] - b[1]);
    for(let i = 0; i < arr.length; i++){
        population += arr[i][1];
        if(population  > maxPopulation){
            ans = arr[i][0];
            maxPopulation = population
        }
    }
    return ans;
};