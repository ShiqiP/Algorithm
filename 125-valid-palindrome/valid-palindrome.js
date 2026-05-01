/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    // abba
    // two pointer 
    let left = 0, right = s.length - 1;
    while(left < right){
        if(checkAlphabet(s[left]) && checkAlphabet(s[right])){
            console.log(left, right)
            if(s[left].toLowerCase() != s[right].toLowerCase()){
                return false;
            }
            left++;
            right--;
        }else if(!checkAlphabet(s[left])){
            left++;
        }else if(!checkAlphabet(s[right])){
            right--;
        }
    }

    function checkAlphabet(c){
        const code = c.toLowerCase().charCodeAt(0);
        return ('a'.charCodeAt() <= code && code <= 'z'.charCodeAt()) ||( code >= '0'.charCodeAt() && code <= '9'.charCodeAt());
    }
    console.log(left, right)
    return true;
};