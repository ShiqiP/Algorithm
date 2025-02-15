/**
 * @param {number} maxSize
 */
var CustomStack = function(maxSize) {
    this.size = maxSize;
    this.stack = new Array(maxSize);
    this.changes = new Array(maxSize).fill(0);
    this.pointer = -1;
};

/** 
 * @param {number} x
 * @return {void}
 */
CustomStack.prototype.push = function(x) {
    if(this.pointer < this.size - 1){
        this.stack[++this.pointer] = x;
    }
};

/**
 * @return {number}
 */
CustomStack.prototype.pop = function() {
    if(this.pointer === -1) return -1;
    return this.stack[this.pointer--];
    // let val = this.stack[pointer] + this.changes[pointer];
    // this.changes[pointer] = 0;
    // pointer --;
    // return val;
};

/** 
 * @param {number} k 
 * @param {number} val
 * @return {void}
 */
CustomStack.prototype.increment = function(k, val) {
    // this.changes = [k, val];
    for(let i = 0; i < Math.min(this.pointer+1, k); i++){
        this.stack[i] += val;
    }
};

/** 
 * Your CustomStack object will be instantiated and called as such:
 * var obj = new CustomStack(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,val)
 */