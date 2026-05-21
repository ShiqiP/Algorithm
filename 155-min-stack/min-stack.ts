class MinStack {
    private stack: Array<number>;
    private min: Array<number>; // min monotonic stack
    constructor() {
        this.stack = [];
        this.min = [];
    }

    push(val: number): void {
        // this.min = Math.min(this.min || Infinity, val);
        this.stack.push(val);
        this.min.length === 0 ? this.min.push(val) : val <= this.min[this.min.length - 1] ? this.min.push(val) : "";
    }

    pop(): void {
        const temp = this.stack.pop();
        if(temp !== null && temp === this.min[this.min.length - 1]) this.min.pop();
    }

    top(): number {
        return this.stack.length === 0 ? null : this.stack[this.stack.length - 1];
    }

    getMin(): number {
        return this.min.length === 0 ? null : this.min[this.min.length - 1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */