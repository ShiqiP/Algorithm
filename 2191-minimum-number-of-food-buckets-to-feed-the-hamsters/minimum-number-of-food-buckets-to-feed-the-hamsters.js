/**
 * @param {string} hamsters
 * @return {number}
 */
var minimumBuckets = function(hamsters) {
    let preBucket = null;
    let ans = 0;
    const n = hamsters.length;
    for(let i = 0; i < hamsters.length; i++){
        if(hamsters[i] === 'H'){
            if(i - 1 === preBucket){
                continue;
            }
            if(i + 1 < n && hamsters[i + 1] === '.'){
                ans ++;
                preBucket = i + 1;
                continue;
            }
            if(i - 1 >= 0 && hamsters[i - 1] === '.'){
                ans ++;
                continue;
            }
            return -1;
        }
    }
    return ans;
};