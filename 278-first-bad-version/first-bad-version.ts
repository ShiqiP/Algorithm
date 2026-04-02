/**
 * The knows API is defined in the parent class Relation.
 * isBadVersion(version: number): boolean {
 *     ...
 * };
 */

var solution = function(isBadVersion: any) {
    // binary
    // n = 5, bad = 4
    // n/2 = 3;
    // [1,2,3] call(mid) === false bad version is on the left side. call from the end to mid + 1
    // call(mid) === true bad version is on the right side. call from mid - 1 to the one is false.
    return function(n: number): number {
        let left = 1;
        let right = n;
        while(left <= right){
            let mid = Math.floor((right + left) / 2);
            if(isBadVersion(mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    };
};