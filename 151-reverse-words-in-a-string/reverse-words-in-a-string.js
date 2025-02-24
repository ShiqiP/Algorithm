/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let ansArr = [];
    let wordArr = [];
    let temp = s + ' ';
    for(let i = 0; i < temp.length; i ++){
        if(temp[i] === ' '){
            if(wordArr.length !== 0){
                ansArr.unshift(wordArr.join(''));
                wordArr = [];
            }
        }else{
            wordArr.push(temp[i]);
        }
    }
    return ansArr.join(' ');
};