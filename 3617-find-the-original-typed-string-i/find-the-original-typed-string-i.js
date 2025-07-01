/**
 * @param {string} word
 * @return {number}
 */
var possibleStringCount = function(word) {
    // letter only appears once would not be typed incorrectly
    // find the letters that appear a least twice
    // done this at most once
    // b 2  c 4
    // b correct c 3
    // c correct b 1
    // b c both correct
    // Sum(length - 1) + 1
    let repeat = 1;
    let ans = 0;
    let pre = word[0];
    for(let i = 1; i <= word.length; i++){
        if(i < word.length && word[i] === pre){
            repeat ++;
        }else{
            if(repeat > 1){
                ans += repeat - 1
                repeat = 1;
            }
        }
        pre = word[i]
    }
    return ans + 1;
};