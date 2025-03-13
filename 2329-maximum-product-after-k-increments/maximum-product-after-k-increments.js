/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximumProduct = function (nums, k) {
    const MOD = Math.pow(10, 9) + 7;
    let heap = new MinHeap(nums);
    let i = 0;
    while (i < k) {
        let least = heap.poll() + 1;
        heap.add(least);
        i++;
    }
    let ans = 1;
    while (!heap.isEmpty()) {
        ans = (ans * heap.poll()) % MOD;
    }
    return ans;
};

class MinHeap {
    constructor(heap = []) {
        this.heap = [];
        heap.forEach(num => this.add(num)); // Fix: Use an arrow function to preserve `this`
    }

    add(num) {
        this.heap.push(num);
        this.heapifyUp();
    }

    peek() {
        return this.heap[0];
    }

    poll() {
        if (this.heap.length === 0) return undefined;
        const top = this.heap[0];
        this.heap[0] = this.heap[this.heap.length - 1];
        this.heap.pop();
        this.heapifyDown();
        return top;
    }

    isEmpty() {
        return this.heap.length === 0;
    }

    heapifyUp() {
        let nodeIndex = this.heap.length - 1;
        while (nodeIndex > 0) {
            const parentIndex = this.getParentIndex(nodeIndex);
            if (this.heap[parentIndex] <= this.heap[nodeIndex]) break;
            this.swap(parentIndex, nodeIndex);
            nodeIndex = parentIndex;
        }
    }

    heapifyDown() {
        let nodeIndex = 0;
        while (true) {
            const leftChildIndex = this.getLeftChildIndex(nodeIndex);
            const rightChildIndex = this.getRightChildIndex(nodeIndex);
            let smallest = nodeIndex;

            if (leftChildIndex < this.heap.length && this.heap[leftChildIndex] < this.heap[smallest]) {
                smallest = leftChildIndex;
            }
            if (rightChildIndex < this.heap.length && this.heap[rightChildIndex] < this.heap[smallest]) {
                smallest = rightChildIndex;
            }
            if (smallest === nodeIndex) break;
            this.swap(nodeIndex, smallest);
            nodeIndex = smallest;
        }
    }

    getParentIndex(childIndex) {
        return Math.floor((childIndex - 1) / 2);
    }

    getLeftChildIndex(parentIndex) {
        return 2 * parentIndex + 1;
    }

    getRightChildIndex(parentIndex) {
        return 2 * parentIndex + 2;
    }

    swap(indexOne, indexTwo) {
        const tmp = this.heap[indexTwo];
        this.heap[indexTwo] = this.heap[indexOne];
        this.heap[indexOne] = tmp;
    }
}