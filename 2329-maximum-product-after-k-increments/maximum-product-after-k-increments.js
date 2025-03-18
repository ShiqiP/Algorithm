/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximumProduct = function (nums, k) {
    const MOD = Math.pow(10, 9) + 7;
    let minHeap = [...nums];
    heapyfy(minHeap);
    let i = 0;
    while (i < k) {
        // let num = minHeap.shift();
        // minHeap.push(num + 1);
        minHeap[0] = minHeap[0] + 1;
        heapyfyUp(minHeap, 0);
        i++;
    }
    let ans = 1;
    for (let num of minHeap) {
        ans = (ans * num) % MOD;
    }
    return ans % MOD;

    function heapyfy(heap) {
        for (let i = Math.floor(heap.length / 2); i >= 0; i--) {
            heapyfyUp(heap, i)
            // let j = i;
            // let k = getMinChild(heap, i);
            // while (k !== 0) {
            //     [heap[j], heap[k]] = [heap[k], heap[j]];
            //     j = k;
            //     k = getMinChild(heap, j);
            // }
        }
    }
    function heapyfyUp(heap, i) {
        let j = i;
        const leftChild = 2 * i + 1;
        const rightChild = 2 * i + 2;
        if (leftChild < heap.length && heap[leftChild] < heap[j]) {
            j = leftChild;
        }
        if (rightChild < heap.length && heap[rightChild] < heap[j]) {
            j = rightChild;
        }
        if (i !== j) {
            [heap[j], heap[i]] = [heap[i], heap[j]];
            heapyfyUp(heap, j)
        }
    }
};
