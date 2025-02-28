/**
 * Finds the length of the Longest Increasing Subsequence (LIS) in an array
 * @param {number[]} numbers - The input array of numbers
 * @return {number} The length of the longest strictly increasing subsequence
 */
var lengthOfLIS = function(numbers) {
    /**
     * Finds the leftmost position where target should be inserted to maintain sorted order
     * @param {number[]} sortedArray - The sorted array to search in
     * @param {number} target - The value to find position for
     * @return {number} The index where target should be inserted
     */
    function findInsertionPosition(sortedArray, target) {
        let leftBound = 0;
        let rightBound = sortedArray.length;
        
        while (leftBound < rightBound) {
            const midPoint = Math.floor((leftBound + rightBound) / 2);
            if (sortedArray[midPoint] < target) {
                leftBound = midPoint + 1;
            } else {
                rightBound = midPoint;
            }
        }
        
        return leftBound;
    }
    
    // subsequence will maintain a sorted auxiliary array 
    // where its length equals the LIS length
    const subsequence = [];
    
    for (const currentNumber of numbers) {
        const insertPosition = findInsertionPosition(subsequence, currentNumber);
        
        if (insertPosition === subsequence.length) {
            // Current number is larger than all elements, extend the subsequence
            subsequence.push(currentNumber);
        } else {
            // Replace the smallest number that's >= currentNumber
            // This maintains the potential for a longer subsequence
            subsequence[insertPosition] = currentNumber;
        }
    }
    
    return subsequence.length;
};