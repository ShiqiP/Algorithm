/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number} k
 * @return {number[]}
 */
var findMaxSum = function (nums1, nums2, k) {
    // key-pair index - number
    // sort arr based on the number
    // 
    let map = [];
    const n = nums1.length;
    let ans = new Array(n).fill(0);
    for (let i = 0; i < n; i++) {
        map.push([i, nums1[i], 0]);
    }
    map.sort((a, b) => a[1] - b[1]);
    let sum = new Array(n).fill(0);
    let minHeap = new MinHeap();
    for (let i = 1; i < n; i++) {
        const preIndex = map[i - 1][0];
        const preValue = map[i - 1][1];
        const index = map[i][0];
        const value = map[i][1];
        if (value > preValue) {
            map[i][2] = i;
        } else {
            map[i][2] = map[i - 1][2];
        }
        let valueInNums2 = nums2[preIndex];
        minHeap.add(valueInNums2);
        sum[i] = sum[i - 1] + valueInNums2;
        if(minHeap.size() > k){
            sum[i] -= minHeap.poll();
        }
        ans[index] = sum[map[i][2]];
    }
    // console.log(map)
    // console.log(sum)
    return ans;
};

class MinHeap {
    constructor() {
        this.heap = [];
    }
    size() {
        return this.heap.length;
    }
    add(value) {
        this.heap.push(value);
        this.upHeap(this.heap.length - 1)
    }
    peek() {
        return this.heap[0]
    }
    poll() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();
        let temp = this.heap[0];
        this.heap[0] = this.heap.pop();
        this.downHeap(0);
        return temp;
    }
    downHeap(i) {
        const n = this.heap.length;
        const left = 2 * i + 1;
        const right = 2 * i + 2;
        let k = i;
        if (left < n && this.heap[left] < this.heap[k]) {
            k = left;
        }
        if (right < n && this.heap[right] < this.heap[k]) {
            k = right;
        }
        if (k !== i) {
            [this.heap[k], this.heap[i]] = [this.heap[i], this.heap[k]];
            this.downHeap(k);
        }
    }
    upHeap(i) {
        let k = i;
        let parent = Math.floor((k - 1) / 2);
        while (parent >= 0) {
            parent = Math.floor((k - 1) / 2);
            if (this.heap[parent] > this.heap[k]) {
                let temp = this.heap[k];
                this.heap[k] = this.heap[parent];
                this.heap[parent] = temp;

            } else {
                break;
            }
            k = parent;
        }
    }
}
