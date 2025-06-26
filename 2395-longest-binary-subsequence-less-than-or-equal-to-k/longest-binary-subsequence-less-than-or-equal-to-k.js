/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var longestSubsequence = function(s, k) {
    
    // combination
    // from right to left


    // when encoutered 1 calculate whether the length is smaller or equal to k
    // if not skip it 
    // else consider it
    let current = 0;
    let bitIndex = 0;
    // i ans  sum   
    // 0 0    0
    // 1 1    2
    // 2 2    2
    // 3 3    2
    // 4 3    2
    // 5 4    2
    //       
    for(let i = s.length - 1; i >= 0; i--){
        const bit = s[i];
        if(bit == 1){
            let sum = current + Math.pow(2, bitIndex);
            if(sum <= k){
                bitIndex ++;
                current = sum;
            }
        }else{
            bitIndex ++;
        }
    }
    return bitIndex;
};