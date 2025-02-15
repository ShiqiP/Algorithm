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
    // return this.stack[this.pointer--];
    let changeVal = this.changes[this.pointer];
    let val = this.stack[this.pointer] + changeVal ;
    this.changes[this.pointer] = 0;
    this.pointer--;
    if(this.pointer !== -1){
        this.changes[this.pointer] += changeVal
    }
    return val;
};

/** 
 * @param {number} k 
 * @param {number} val
 * @return {void}
 */
CustomStack.prototype.increment = function(k, val) {
    if(this.pointer === -1) return;
    this.changes[Math.min(k - 1, this.pointer)] += val;
};

/** 
 * Your CustomStack object will be instantiated and called as such:
 * var obj = new CustomStack(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,val)
 */