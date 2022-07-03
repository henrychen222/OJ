///////////////////////////////// pre-define ////////////////////////////////////////////////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const mxll = (...args) => args.reduce((m, e) => e > m ? e : m);
const mill = (...args) => args.reduce((m, e) => e < m ? e : m);
const sqll = (v) => { if (v < 0n) throw 'negative input'; if (v < 2n) return v; const dfs = (n, x0) => { let x1 = ((n / x0) + x0) >> 1n; if (x0 === x1 || x0 === (x1 - 1n)) return x0; return dfs(n, x1); }; return dfs(v, 1n); }; // has >> 0
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
const lge = Math.log;
const lg10 = Math.log10;
const ll = BigInt;
const combination = (m, n) => { return factorial(m, n) / factorial(n, n); };
const factorial = (m, n) => { let num = 1n; let cnt = 0; for (let i = ll(m); i > 0; i--) { if (cnt == n) break; num *= i; cnt++; } return num; };
const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);
const lcm = (a, b) => (a / gcd(a, b)) * b;
const bitCount = (n) => { n = n - ((n >> 1) & 0x55555555); n = (n & 0x33333333) + ((n >> 2) & 0x33333333); return ((n + (n >> 4) & 0xF0F0F0F) * 0x1010101) >> 24; };
const powmod = (a, b, mod) => { let r = 1n; while (b > 0n) { if (b % 2n == 1) r = r * a % mod; b >>= 1n; a = a * a % mod; } return r; };
const amax = (a) => mx.apply(Math, a);
const amin = (a) => mi.apply(Math, a);
const sm = (a) => a.reduce(((x, y) => x + y), 0);
const aeq = (a, b) => JSON.stringify(a) == JSON.stringify(b);
const swap = (a, i, j) => [a[i], a[j]] = [a[j], a[i]];
const stin = (a) => a.sort((x, y) => x - y);
const stde = (a) => a.sort((x, y) => y - x);
const sortPart = (a, k) => { let l = a.slice(0, k); l.sort((x, y) => x - y); let r = a.slice(k); return l.concat(r); }; // sort first kth
const initialize2DArrayNew = (m, n) => { let data = []; for (let i = 0; i < m; i++) { let tmp = Array(n).fill(0); data.push(tmp); } return data; };
const stmkey_in = (m) => new Map([...m].sort((x, y) => x[0] - y[0]));
const stmkey_de = (m) => new Map([...m].sort((x, y) => y[0] - x[0]));
const stmvalue_in = (m) => new Map([...m].sort((x, y) => x[1] - y[1]));
const stmvalue_de = (m) => new Map([...m].sort((x, y) => y[1] - x[1]));
const counter = (a_or_s) => { let map = new Map(); for (const i of a_or_s) map.set(i, map.get(i) + 1 || 1); return map; };
const counter_value_in_indexA_in = (a_or_s) => { let m = new Map(); let n = a_or_s.length; for (let i = 0; i < n; i++) { if (!m.has(a_or_s[i])) m.set(a_or_s[i], []); m.get(a_or_s[i]).push(i); } return m; };
const counter_value_in_indexA_de = (a_or_s) => { let m = new Map(); let n = a_or_s.length; for (let i = 0; i < n; i++) { if (!m.has(a_or_s[i])) m.set(a_or_s[i], []); m.get(a_or_s[i]).unshift(i); } return m; };
const reverse2 = (s) => { let res = ""; for (let i = s.length - 1; i >= 0; i--) { res += s[i]; } return res; };
const isPalindrome = (s) => { let n = s.length; let i = 0; let j = n - 1; while (i < j) { if (s[i++] != s[j--]) return false; } return true; };
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 05/28/21 night

// Accepted --- https://codeforces.com/contest/1526/submission/117728728 77ms
const solve = (n, a) => {
    let pq = new MinPriorityQueue({ priority: x => x }); // save all negative nums
    let res = sum = 0;
    for (const e of a) {
        sum += e;
        res++;
        // pr("begin", sum, res)
        if (e < 0) {
            pq.enqueue(e);
            while (sum < 0) {
                sum -= pq.dequeue().element; // greedy: each time use the min negative num, largest abs num to make sum >= 0, then res-- to be minimum
                res--;
                // pr("sum < 0", sum, res, pq.toArray())
            }
        }
        // pr("end", sum, res)
    }
    pr(res);
};

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
        solve(input[0][0], input[1]);
    });
};

main()