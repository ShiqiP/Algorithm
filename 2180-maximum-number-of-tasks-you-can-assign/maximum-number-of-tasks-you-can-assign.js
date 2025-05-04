/**
 * @param {number[]} tasks
 * @param {number[]} workers
 * @param {number} pills
 * @param {number} strength
 * @return {number}
 */
var maxTaskAssign = function (tasks, workers, pills, strength) {
    // sort 
    // k <= min worker.length,tasks.length
    // k strongest workers complete k smallest task
    workers.sort((a,b) => a - b);
    tasks.sort((a,b) => a - b);
    //  task effort - strength <= worker.length
    const n = tasks.length;
    const m = workers.length;
    let left = 0, right = Math.min(n, m);
    let ans = 0;
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        if (check(mid)) {
            ans = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return ans;
    function check(mid) {
        let p = pills;
        let ws = [];
        let last = m - 1;
        for (let i = mid - 1; i >= 0; i--) {
            while(last >= m - mid && workers[last] + strength >= tasks[i]){
                ws.unshift(workers[last]);
                last --;
            }
            if(ws.length === 0 ) return false;
            if(ws[ws.length - 1] >= tasks[i]){
                ws.pop();
            }else{
                if(p === 0) return false;
                ws.shift();
                p--;
            }
        }
        return true;
    }

};