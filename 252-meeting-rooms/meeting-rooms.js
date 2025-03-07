/**
 * @param {number[][]} intervals
 * @return {boolean}
 */
var canAttendMeetings = function (intervals) {
    let statusArr = [];
    for (let i = 0; i < intervals.length; i++) {
        const start = intervals[i][0];
        const end = intervals[i][1];
        statusArr.push([start, 1]);
        statusArr.push([end, -1]);
    }
    statusArr.sort((a, b) => (a[0] - b[0] || a[1] - b[1]));
    let attend = 0;
    for (let i = 0; i < statusArr.length; i++) {
        attend += statusArr[i][1];
        if(attend > 1){
            return false;
        }
    }
    return true;
};