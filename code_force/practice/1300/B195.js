/**
 * 10/13/22 evening
 * https://codeforces.com/problemset/problem/195/B
 */

const pr = console.log;

class Heap {
    constructor(nodes, leaf) {
        this._nodes = Array.isArray(nodes) ? nodes : [];
        this._leaf = leaf || null;
    }
    _hasLeftChild(parentIndex) {
        const leftChildIndex = (parentIndex * 2) + 1;
        return leftChildIndex < this.size();
    }
    _hasRightChild(parentIndex) {
        const rightChildIndex = (parentIndex * 2) + 2;
        return rightChildIndex < this.size();
    }
    _getKey(node) {
        if (typeof node === 'object') return node.key;
        return node;
    }
    _swap(i, j) {
        const temp = this._nodes[i];
        this._nodes[i] = this._nodes[j];
        this._nodes[j] = temp;
    }
    _compare(parentNode, childNode) {
        return this._compareKeys(this._getKey(parentNode), this._getKey(childNode));
    }
    _shouldSwap(parentIndex, childIndex) {
        if (parentIndex < 0 || parentIndex >= this.size()) return false;
        if (childIndex < 0 || childIndex >= this.size()) return false;
        return !this._compare(this._nodes[parentIndex], this._nodes[childIndex]);
    }
    heapifyUp(startingIndex) {
        let childIndex = startingIndex, parentIndex = Math.floor((childIndex - 1) / 2);
        while (this._shouldSwap(parentIndex, childIndex)) {
            this._swap(parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = Math.floor((childIndex - 1) / 2);
        }
    }
    _compareChildrenOf(parentIndex) {
        if (!this._hasLeftChild(parentIndex) && !this._hasRightChild(parentIndex)) return -1;
        const leftChildIndex = (parentIndex * 2) + 1, rightChildIndex = (parentIndex * 2) + 2;
        if (!this._hasLeftChild(parentIndex)) return rightChildIndex;
        if (!this._hasRightChild(parentIndex)) return leftChildIndex;
        const isLeft = this._compare(this._nodes[leftChildIndex], this._nodes[rightChildIndex]);
        return isLeft ? leftChildIndex : rightChildIndex;
    }
    _heapifyDown(startingIndex) {
        let parentIndex = startingIndex, childIndex = this._compareChildrenOf(parentIndex);
        while (this._shouldSwap(parentIndex, childIndex)) {
            this._swap(parentIndex, childIndex);
            parentIndex = childIndex;
            childIndex = this._compareChildrenOf(parentIndex);
        }
    }
    extractRoot() {
        if (this.isEmpty()) return null;
        const root = this.root();
        this._nodes[0] = this._nodes[this.size() - 1];
        this._nodes.pop();
        this._heapifyDown(0);
        if (root === this._leaf) this._leaf = this.root();
        return root;
    }
    _heapifyDownUntil(index) {
        let parentIndex = 0, leftChildIndex = 1, rightChildIndex = 2, childIndex;
        while (leftChildIndex < index) {
            childIndex = this._compareChildrenBefore(index, leftChildIndex, rightChildIndex);
            if (this._shouldSwap(parentIndex, childIndex)) this._swap(parentIndex, childIndex);
            parentIndex = childIndex;
            leftChildIndex = (parentIndex * 2) + 1;
            rightChildIndex = (parentIndex * 2) + 2;
        }
    }
    _clone(HeapType) {
        return new HeapType(this._nodes.slice(), this._leaf);
    }
    sort() {
        for (let i = this.size() - 1; i > 0; i -= 1) {
            this._swap(0, i);
            this._heapifyDownUntil(i);
        }
        return this._nodes;
    }
    insert(key, value) {
        const newNode = value !== undefined ? { key, value } : key;
        this._nodes.push(newNode);
        this.heapifyUp(this.size() - 1);
        if (this._leaf === null || !this._compare(newNode, this._leaf)) this._leaf = newNode;
        return this;
    }
    fix() {
        for (let i = 0; i < this.size(); i += 1) this.heapifyUp(i);
        return this;
    }
    isValid() {
        const isValidRecursive = (parentIndex) => {
            let isValidLeft = true, isValidRight = true;
            if (this._hasLeftChild(parentIndex)) {
                const leftChildIndex = (parentIndex * 2) + 1;
                isValidLeft = this._compare(this._nodes[parentIndex], this._nodes[leftChildIndex]);
                if (!isValidLeft) return false;
                isValidLeft = isValidRecursive(leftChildIndex);
            }
            if (this._hasRightChild(parentIndex)) {
                const rightChildIndex = (parentIndex * 2) + 2;
                isValidRight = this._compare(this._nodes[parentIndex], this._nodes[rightChildIndex]);
                if (!isValidRight) return false;
                isValidRight = isValidRecursive(rightChildIndex);
            }
            return isValidLeft && isValidRight;
        };
        return isValidRecursive(0);
    }
    root() {
        if (this.isEmpty()) return null;
        return this._nodes[0];
    }
    leaf() {
        return this._leaf;
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
    static _heapify(list, HeapType) {
        if (!Array.isArray(list)) throw new Error('.heapify expects an array');
        return new HeapType(list).fix();
    }
    static _isHeapified(list, HeapType) {
        return new HeapType(list).isValid();
    }
}

class MinHeap extends Heap {
    _compareKeys(parentKey, childKey) {
        return parentKey < childKey;
    }
    _compareChildrenBefore(index, leftChildIndex, rightChildIndex) {
        const leftChildKey = this._getKey(this._nodes[leftChildIndex]);
        const rightChildKey = this._getKey(this._nodes[rightChildIndex]);
        if (rightChildKey < leftChildKey && rightChildIndex < index) return rightChildIndex;
        return leftChildIndex;
    }
    clone() {
        return super._clone(MinHeap);
    }
    static heapify(list) {
        return super._heapify(list, MinHeap);
    }
    static isHeapified(list) {
        return super._isHeapified(list, MinHeap);
    }
}

class CustomHeap extends Heap {
    constructor(comparator, nodes, leaf) {
        if (typeof comparator !== 'function') {
            throw new Error('CustomHeap expects a comparator function');
        }
        super(nodes, leaf);
        this._comparator = comparator;
    }
    _compare(parentNode, childNode) {
        return this._comparator(parentNode, childNode) <= 0;
    }
    _compareChildrenBefore(index, leftChildIndex, rightChildIndex) {
        const compare = this._comparator(this._nodes[rightChildIndex], this._nodes[leftChildIndex]);
        if (compare <= 0 && rightChildIndex < index) return rightChildIndex;
        return leftChildIndex;
    }
    clone() {
        return new CustomHeap(this._comparator, this._nodes.slice(), this._leaf);
    }
    static heapify(list, comparator) {
        if (!Array.isArray(list)) throw new Error('.heapify expects an array');
        if (typeof comparator !== 'function') throw new Error('.heapify expects a comparator function');
        return new CustomHeap(comparator, list).fix();
    }
    static isHeapified(list, comparator) {
        if (!Array.isArray(list)) throw new Error('.heapify expects an array');
        if (typeof comparator !== 'function') throw new Error('.isHeapified expects a comparator function');
        return new CustomHeap(comparator, list).isValid();
    }
}

class PriorityQueue {
    constructor(options = {}) {
        const { priority, compare } = options;
        if (compare) {
            if (typeof compare !== 'function') throw new Error('.constructor expects a valid compare function');
            this._compare = compare;
            this._heap = new CustomHeap(this._compare);
        } else {
            if (priority !== undefined && typeof priority !== 'function') throw new Error('.constructor expects a valid priority function');
            this._priority = priority || ((el) => +el);
        }
    }
    _getElementWithPriority(node) {
        return { priority: node.key, element: node.value };
    }
    size() {
        return this._heap.size();
    }
    isEmpty() {
        return this._heap.isEmpty();
    }
    front() {
        if (this.isEmpty()) return null;
        if (this._compare) return this._heap.root();
        return this._getElementWithPriority(this._heap.root());
    }
    back() {
        if (this.isEmpty()) return null;
        if (this._compare) return this._heap.leaf();
        return this._getElementWithPriority(this._heap.leaf());
    }
    enqueue(element, p) {
        if (this._compare) {
            this._heap.insert(element);
            return this;
        }
        if (p && Number.isNaN(+p)) throw new Error('.enqueue expects a numeric priority');
        if (Number.isNaN(+p) && Number.isNaN(this._priority(element))) {
            throw new Error('.enqueue expects a numeric priority ' + 'or a constructor callback that returns a number');
        }
        const priority = !Number.isNaN(+p) ? p : this._priority(element);
        this._heap.insert(+priority, element);
        return this;
    }
    dequeue() {
        if (this.isEmpty()) return null;
        if (this._compare) return this._heap.extractRoot();
        return this._getElementWithPriority(this._heap.extractRoot());
    }
    toArray() {
        if (this._compare) return this._heap.clone().sort().reverse();
        return this._heap.clone().sort().map((n) => this._getElementWithPriority(n)).reverse();
    }
    clear() {
        this._heap.clear();
    }
}

class MinPriorityQueue extends PriorityQueue {
    constructor(options) {
        super(options);
        if (!this._compare) {
            this._heap = new MinHeap();
        }
    }
}

// Accepted --- https://codeforces.com/problemset/submission/195/176085291
const solve = (n, m) => { // n: ball  m: basket
    let pq = new MinPriorityQueue({
        compare: (x, y) => {
            if (x[0] != y[0]) return x[0] - y[0]; // least number of ball
            if (x[1] != y[1]) return x[1] - y[1] // stands closer to the middle
            return x[2] - y[2];
        }
    });
    for (let i = 1; i <= m; i++) {
        let dis = Math.abs((m + 1) / 2 - i);
        pq.enqueue([0, dis, i]);
    }
    // pr("begin", pq.toArray());
    let g = [], res = Array(n + 1).fill(0);
    for (let i = 0; i <= m; i++) g.push([]);
    for (let i = 1; i <= n; i++) {
        let cur = pq.dequeue();
        cur[0]++;
        g[cur[2]].push(i);
        // pr('ball', i, 'basket', cur[2], g)
        pq.enqueue(cur);
    }
    // pr("after", pq.toArray());
    // pr("g", g)
    for (let i = 1; i <= m; i++) {
        for (const ball of g[i]) res[ball] = i;
    }
    // pr(res)
    for (let i = 1; i <= n; i++) pr(res[i]);
};

const main = () => {
    const readLine = () => input[currentLine++];
    const ni = () => readLine() - '0';
    const nl = () => BigInt(readLine());
    const nas = () => readLine().split(" ");
    const nai = () => nas().map(Number);
    const nal = () => nas().map(BigInt);
    let input = '', currentLine = 0;
    process.stdin.on('data', (stdin) => input += stdin)
    process.stdin.on('end', () => {
        input = input.split('\n');
        let [n, m] = nai();
        solve(n, m);
    });
};

main()