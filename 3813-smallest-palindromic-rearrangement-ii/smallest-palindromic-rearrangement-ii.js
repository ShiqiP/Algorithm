/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
let factorialDP = [1n, 1n]; //Outside the function so it acn be reused for all the test cases, kinda like a global variable.
var smallestPalindrome = function (s, k) {
    // a simple factorial function
    let calculateFact = (n) => {
        if (factorialDP[n]) {
            return factorialDP[n];
        } else {
            return BigInt(n) * calculateFact(n - 1);
        }
    }
//handling a base case
    let len = s?.length;
    if (len == 1) {
        if (k > 1) {
            return "";
        } else {
            return s;
        }
    }
// you can either construct it before, or iterate over string and then sort the keys, upto you
    let alphabet = {
        a: 0,
        b: 0,
        c: 0,
        d: 0,
        e: 0,
        f: 0,
        g: 0,
        h: 0,
        i: 0,
        j: 0,
        k: 0,
        l: 0,
        m: 0,
        n: 0,
        o: 0,
        p: 0,
        q: 0,
        r: 0,
        s: 0,
        t: 0,
        u: 0,
        v: 0,
        w: 0,
        x: 0,
        y: 0,
        z: 0,
    };
    let string = new Array(len);
    let combo = 1n; //1n is bigint, using normal integer won't work as limits are high
//only traversing half the string, because it is a palindrome, we already know the other half

    for (let i = 0; i < Math.floor(len / 2); i++) {
        alphabet[s[i]] += 1;
        combo *= BigInt(i + 1);
    }
    let lenLeft = BigInt(Math.floor(len / 2));
    let fact = 1n;
    if (len % 2 != 0) {
        string[lenLeft] = s[lenLeft];
    }
    for (let [key] in alphabet) {
        if (alphabet[key] == 0) {
            delete alphabet[key]; //deleting unused letters for making traversal shorter
            continue;
        }
        fact *= calculateFact(alphabet[key]);
    }

//combo is the numerator, and fact is the denominator according to example explained in the approach section, resulting in total combinations
    let combinations = combo / fact;
//case where k is greater than possible combinations.
    if (combinations < BigInt(k)) {
        return "";
    }
    let stringIndex = 0;
    let lexicalNumer = 0n; // the number of strings we have already found so far, or the position of a string in the order. 
//We keep fixing letters one by one, and check if it works. This is basic math from 10th permutation and combination, and a popular question of finding position in dictionary. 

    while (stringIndex < Math.floor(len / 2)) {
        for (let [key] in alphabet) {
            //we fix the current letter and see how many possible string we can generate from here. 
            let possibleCombos =
                (combinations * BigInt(alphabet[key])) / (lenLeft);
            let newLexicalNumber = lexicalNumer + possibleCombos;
            //if combos are more than k, it means, we will achieve the desired string by fixing the letter, else, we will update lexical number, saying we have already traversed these many stirngs. 
            if (k <= newLexicalNumber) {
                //fixing the letters in string
                string[stringIndex] = key;
                string[len - 1 - stringIndex] = key;
                //updating values
                stringIndex++;
                combinations = possibleCombos;
                lenLeft--;
                alphabet[key] -= 1;
                if (alphabet[key] == 0) {
                    delete alphabet[key];
                }
                break;
            } else {
                lexicalNumer = newLexicalNumber;
            }
        }
    }
    return string?.join("");
};