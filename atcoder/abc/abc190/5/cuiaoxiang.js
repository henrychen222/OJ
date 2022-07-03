/**
 * 1.30 morning  02/19/20 fixed initializeGraph() issue and PQ issue
 * https://atcoder.jp/contests/abc190/tasks/abc190_e
 * https://atcoder.jp/contests/abc190/submissions?f.User=cuiaoxiang
 * https://atcoder.jp/contests/abc190/submissions/19795513
 */

// Accepted --- 1857ms https://atcoder.jp/contests/abc190/submissions/20273924
const MAX = Number.MAX_SAFE_INTEGER;
const solve = (n, m, ab, k, c) => {
    // console.log(n, m, ab, k, c);
    // let a = Array(n).fill([]); // issue here
    let G = initializeGraph(n);
    // console.log(G);
    for (let i = 0; i < m; i++) {
        let x = ab[i][0];
        let y = ab[i][1];
        --x;
        --y;
        // console.log(x, y);
        G[x].push(y);  // fixed: WTF, why push to all? second case should be [[3][][][0]] -> [[3][3][][0 1]] -> [[3 1][3 0][][0 1]]
        G[y].push(x);
        // console.log(G);
    }
    let dists = initializeGraph(k);
    for (let i = 0; i < k; i++) {
        c[i]--;
        dists[i] = dijkstra(G, c[i]);
    }
    // console.log(n, m, ab, k, c);
    // console.log("dists", dists);
    // console.log(G);
    let dp = initialize2DArrayNew(1 << k, k);
    // console.log(dp);
    for (let i = 1; i < 1 << k; i++) {
        for (let j = 0; j < k; j++) {
            if (((i >> j) & 1) == 0) continue;
            if (i == 1 << j) dp[i][j] = 1;
            for (let t = 0; t < k; t++) {
                if ((i >> t) & 1) continue;
                dp[i ^ (1 << t)][t] = Math.min(dp[i ^ (1 << t)][t], dists[j][c[t]] + dp[i][j]);
                // update(dp[i ^ (1 << t)][t], dists[j][c[t]] + dp[i][j]); // wrong, c++ reference different
            }
        }
    }
    // console.log(dp);
    let res = MAX;
    for (let i = 0; i < k; i++) {
        res = Math.min(res, dp[(1 << k) - 1][i]);
    }
    console.log(res == MAX ? -1 : res);
};

const dijkstra = (G, src) => { // first example G: [[ 3 ], [ 3 ], [ 3 ], [ 0, 1, 2 ]]
    let n = G.length;
    let dist = Array(n).fill(MAX);
    dist[src] = 0;
    let pq = new MinPriorityQueue({
        priority: x => x.first
    });
    pq.enqueue({ first: dist[src], second: src });
    while (!pq.isEmpty()) {
        let cur = pq.dequeue().element;
        let curd = cur.first;
        let curS = cur.second;
        // console.log(curd, curS);
        // if (curd != curS) continue; // fuck, copy wrong
        if (curd != dist[curS]) continue;
        for (const e of G[curS]) {
            if (dist[e] > dist[curS] + 1) {
                dist[e] = dist[curS] + 1;
                pq.enqueue({ first: dist[e], second: e });
            }
        }
    }
    return dist;
};

// const update = (x, y) => {
//     x = Math.min(x, y);
// };

const bitCount = (n) => {
    n = n - ((n >> 1) & 0x55555555);
    n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
    return ((n + (n >> 4) & 0xF0F0F0F) * 0x1010101) >> 24;
}

const initializeGraph = (n) => {
    let G = [];
    for (let i = 0; i < n; i++) {
        G.push([]);
    }
    return G;
};

const initialize2DArrayNew = (m, n) => {
    let data = [];
    for (let i = 0; i < m; i++) {
        let tmp = new Array(n).fill(MAX);
        data.push(tmp);
    }
    return data;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" ").map(x => Number(x)));
    });
    rl.on('close', () => {
        let n = input[0][0];
        let m = input[0][1];
        solve(n, m, input.slice(1, 1 + m), input[1 + m][0], input[m + 2]);
    });
};

main()
// let a = Array(3).fill([]);
// for (let i = 0; i < 1; i++) {
//     a[0].push(3);
// }
// console.log(a); // why not [[3], [], []]


// console.log(bitCount(4)); // 1
// console.log(bitCount(5)); // 2
// console.log(bitCount(7)); // 3

// console.log(dijkstra([[3], [3], [0, 1, 2]], 0));


//////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////// MinPriorityQueue ////////////////////////////////////////////
class HeapNode {
    constructor(key, value) {
        this._key = key;
        this._value = value;
    }

    getKey() {
        return this._key;
    }

    getValue() {
        return this._value;
    }
}

const isNumber = (n) => typeof n === 'number';
const isNoneEmptyString = (s) => typeof s === 'string' && s.length;
const isNoneNullObject = (o) => typeof o === 'object' && o !== null;
const isNoneEmptyArray = (a) => Array.isArray(a) && a.length > 0;

class Heap {
    constructor(nodes) {
        this._nodes = Array.isArray(nodes) ? nodes : [];
        this._leaf = null;
    }

    _getLeftChildIndex(parentIndex) {
        return (parentIndex * 2) + 1;
    }

    _getRightChildIndex(parentIndex) {
        return (parentIndex * 2) + 2;
    }

    _getParentIndex(childIndex) {
        return Math.floor((childIndex - 1) / 2);
    }

    _getLastIndex() {
        return this._nodes.length - 1;
    }

    _swap(i, j) {
        const temp = this._nodes[i];
        this._nodes[i] = this._nodes[j];
        this._nodes[j] = temp;
    }

    _compareChildrenOf(parentIndex) {
        const leftChildIndex = this._getLeftChildIndex(parentIndex);
        const rightChildIndex = this._getRightChildIndex(parentIndex);
        const size = this.size();
        if (leftChildIndex >= size && rightChildIndex >= size) return -1;
        if (leftChildIndex >= size) return rightChildIndex;
        if (rightChildIndex >= size) return leftChildIndex;
        return this._compareChildren(leftChildIndex, rightChildIndex);
    }

    _heapifyUp() {
        let childIndex = this._getLastIndex();
        let parentIndex = this._getParentIndex(childIndex);
        while (this._shouldSwap(childIndex, parentIndex)) {
            this._swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = this._getParentIndex(childIndex);
        }
    }

    _heapifyDown() {
        let parentIndex = 0;
        let childIndex = this._compareChildrenOf(parentIndex);
        while (this._shouldSwap(childIndex, parentIndex)) {
            this._swap(childIndex, parentIndex);
            parentIndex = childIndex;
            childIndex = this._compareChildrenOf(parentIndex);
        }
    }

    _heapifyDownUntil(index) {
        let parentIndex = 0;
        let leftChildIndex = 1;
        let rightChildIndex = 2;
        let childIndex;
        while (leftChildIndex < index) {
            childIndex = this._compareChildrenBefore(
                index,
                leftChildIndex,
                rightChildIndex
            );
            if (this._shouldSwap(childIndex, parentIndex)) {
                this._swap(childIndex, parentIndex);
            }
            parentIndex = childIndex;
            leftChildIndex = this._getLeftChildIndex(parentIndex);
            rightChildIndex = this._getRightChildIndex(parentIndex);
        }
    }

    _clone(HeapType) {
        return new HeapType(this._nodes.slice());
    }

    sort() {
        for (let i = this._getLastIndex(); i > 0; i -= 1) {
            this._swap(0, i);
            this._heapifyDownUntil(i);
        }
        return this._nodes;
    }

    insert(key, value) {
        const newNode = new HeapNode(key, value);
        this._nodes.push(newNode);
        this._heapifyUp();
        return newNode;
    }

    root() {
        if (this.isEmpty()) return null;
        return this._nodes[0];
    }

    leaf() {
        return this._leaf;
    }

    extractRoot() {
        if (this.isEmpty()) return null;
        const root = this.root();
        this._nodes[0] = this._nodes[this._getLastIndex()];
        this._nodes.pop();
        this._heapifyDown();
        if (root === this._leaf) {
            if (this.isEmpty()) {
                this._leaf = null;
            } else {
                this._leaf = this.root();
            }
        }
        return root;
    }

    size() {
        return this._nodes.length;
    }

    isEmpty() {
        return this.size() === 0;
    }

    clear() {
        this._nodes = [];
        this._leaf = null;
    }

    static _heapify(items, HeapType) {
        if (!isNoneEmptyArray(items)) return null;
        const heap = new HeapType();
        items.forEach((item) => {
            if (isNumber(item) || isNoneEmptyString(item)) {
                heap.insert(item);
            } else if (isNoneNullObject(item) &&
                (isNumber(item.key) || isNoneEmptyString(item.key))) {
                heap.insert(item.key, item.value);
            }
        });
        return heap;
    }
}

class MinHeap extends Heap {
    _getMinChildIndex(leftChildIndex, rightChildIndex) {
        const leftChild = this._nodes[leftChildIndex];
        const rightChild = this._nodes[rightChildIndex];
        if (leftChild.getKey() < rightChild.getKey()) {
            return leftChildIndex;
        }
        return rightChildIndex;
    }

    _getMinChildIndexBefore(index, leftChildIndex, rightChildIndex) {
        const leftChild = this._nodes[leftChildIndex];
        const rightChild = this._nodes[rightChildIndex];
        if (rightChild.getKey() < leftChild.getKey() && rightChildIndex < index) {
            return rightChildIndex;
        }
        return leftChildIndex;
    }

    _shouldSwap(childIndex, parentIndex) {
        if (childIndex < 0 || childIndex >= this.size()) return false;
        if (parentIndex < 0 || parentIndex >= this.size()) return false;
        const child = this._nodes[childIndex];
        const parent = this._nodes[parentIndex];
        return child.getKey() < parent.getKey();
    }

    _compareChildren(leftChildIndex, rightChildIndex) {
        return this._getMinChildIndex(leftChildIndex, rightChildIndex);
    }

    _compareChildrenBefore(index, leftChildIndex, rightChildIndex) {
        return this._getMinChildIndexBefore(index, leftChildIndex, rightChildIndex);
    }

    insert(key, value) {
        const newNode = super.insert(key, value);
        if (this._leaf === null || key > this._leaf.getKey()) {
            this._leaf = newNode;
        }
        return newNode;
    }

    clone() {
        return super._clone(MinHeap);
    }

    static heapify(items) {
        return super._heapify(items, MinHeap);
    }
}

class PriorityQueue {
    constructor(options = {}) {
        const {
            priority
        } = options;
        if (priority !== undefined && typeof priority !== 'function') {
            throw new Error('invalid priority callback');
        }
        this._getPriority = typeof priority === 'function' ? priority : null;
    }

    size() {
        return this._heap.size();
    }

    isEmpty() {
        return this._heap.isEmpty();
    }

    front() {
        if (this.isEmpty()) return null;
        const first = this._heap.root();
        return {
            priority: first.getKey(),
            element: first.getValue()
        };
    }

    back() {
        if (this.isEmpty()) return null;
        const last = this._heap.leaf();
        return {
            priority: last.getKey(),
            element: last.getValue()
        };
    }

    enqueue(element, p) {
        if (p && Number.isNaN(+p)) {
            throw new Error('invalid priority number');
        }
        if (Number.isNaN(+p) && this._getPriority === null) {
            throw new Error('missing priority number or constructor callback');
        }
        const priority = !Number.isNaN(+p) ? p : this._getPriority(element);
        this._heap.insert(priority, element);
    }

    dequeue() {
        if (this.isEmpty()) return null;
        const first = this._heap.extractRoot();
        return {
            priority: first.getKey(),
            element: first.getValue()
        };
    }

    toArray() {
        return this._heap
            .clone()
            .sort()
            .map((n) => ({
                priority: n.getKey(),
                element: n.getValue()
            }))
            .reverse();
    }

    clear() {
        this._heap.clear();
    }
}

class MinPriorityQueue extends PriorityQueue {
    constructor(options) {
        super(options);
        this._heap = new MinHeap();
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////