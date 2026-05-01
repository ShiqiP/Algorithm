/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    // abba
    // two pointer 
    let left = 0, right = s.length - 1;
    while(left < right){
        while(left < right && !checkAlphabet(s[left])){
            left++;
        }

        while(left < right && !checkAlphabet(s[right])){
            right--;
        }
        if(s[left].toLowerCase() != s[right].toLowerCase()){
            return false;
        }
        left++;
        right--;
      
    }

    function checkAlphabet(c){
        const code = c.toLowerCase().charCodeAt(0);
        return ('a'.charCodeAt() <= code && code <= 'z'.charCodeAt()) 
        ||( code >= '0'.charCodeAt() && code <= '9'.charCodeAt());
    }
    return true;
};