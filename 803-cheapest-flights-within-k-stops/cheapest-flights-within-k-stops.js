var findCheapestPrice = function (n, flights, src, dst, k) {
    // Graph creation
    let map = new Array(n).fill(null).map(() => []);
    for (let flight of flights) {
        map[flight[0]].push([flight[1], flight[2]]);
    }
    
    // Min-heap
    let heap = new Minheap();
    heap.add([src, 0, -1]);  // [node, cost, stops]
    
    // Distance table to store minimum cost at each node and stop count
    let dist = new Array(n).fill(null).map(() => new Array(k + 2).fill(Infinity));
    dist[src][0] = 0;
    
    while (!heap.empty()) {
        let [node, cost, stops] = heap.poll();
        
        // If we've reached the destination with valid stops
        if (node === dst) return cost;

        // If there are more stops left to process
        if (stops < k) {
            for (let [nei, price] of map[node]) {
                let newCost = cost + price;
                if (newCost < dist[nei][stops + 1]) {
                    dist[nei][stops + 1] = newCost;
                    heap.add([nei, newCost, stops + 1]);
                }
            }
        }
    }
    
    return -1;  // If no valid path found
};

// Min-Heap implementation
class Minheap {
    constructor() {
        this.heap = [];
    }

    empty() {
        return this.heap.length === 0;
    }

    add(val) {
        this.heap.push(val);
        this.upheap(this.heap.length - 1);
    }

    poll() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();
        this.swap(0, this.heap.length - 1);
        const res = this.heap.pop();
        this.downheap(0);
        return res;
    }

    upheap(i) {
        let k = i;
        while (this.getParent(k) >= 0) {
            if (this.heap[k][1] < this.heap[this.getParent(k)][1]) {
                this.swap(k, this.getParent(k));
                k = this.getParent(k);
            } else {
                break;
            }
        }
    }

    downheap(i) {
        let k = i;
        let left = this.getLeftChild(k);
        let right = this.getRightChild(k);
        let smallest = k;

        if (left < this.heap.length && this.heap[left][1] < this.heap[smallest][1]) {
            smallest = left;
        }
        if (right < this.heap.length && this.heap[right][1] < this.heap[smallest][1]) {
            smallest = right;
        }
        if (smallest !== k) {
            this.swap(k, smallest);
            this.downheap(smallest);
        }
    }

    getParent(i) {
        return Math.floor((i - 1) / 2);
    }

    getLeftChild(i) {
        return 2 * i + 1;
    }

    getRightChild(i) {
        return 2 * i + 2;
    }

    swap(a, b) {
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
    }
}
