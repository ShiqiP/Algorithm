/**
 * @param {number[][]} intervals
 * @return {number}
 */
var minMeetingRooms = function(intervals) {
    let arr = []; // [time,type] type 0 start 1 end
    for(let interval of intervals){
        arr.push([interval[0],0]);
        arr.push([interval[1],1]);
    }
    arr.sort((a,b) => a[0] - b[0] || b[1] - a[1]);
    console.log(arr)
    let ans = 0;
    let cur = 0;
    for(let el of arr){
        if(el[1] === 0){
            cur++;
        }else{
            cur--;
        }
        if(cur > ans){
            ans = cur;
        }
    }
    return ans;
};