/**
 *  10.12 night
 *  https://codeforces.com/problemset/problem/6/E
 *
 *  reference:
 *  https://codeforces.com/problemset/status/6/problem/E/page/46?order=BY_PROGRAM_LENGTH_ASC
 *  https://codeforces.com/problemset/submission/6/94367599
 */

function For(a, b, fn) {
    if (!fn) return For(0, a - 1, b);
    let res;
    for (let i = a; i <= b; i++) {
        if ((res = fn(i)) != null) return res;
    }
}

function ForR(a, b, fn) {
    if (!fn) return ForR(a - 1, 0, b);
    let res;
    for (let i = a; i >= b; i--) {
        if ((res = fn(i)) != null) return res;
    }
}

function Arr(a, b, fn, init) {
    if (typeof (b) == 'function') return Arr(0, a - 1, b, fn);
    if (b < a) return [];
    let arr = Array(b - a + 1).fill(0);
    if (init) init(arr);
    for (let i = a; i <= b; i++) arr[i] = fn(i, arr);
    return arr;
}

Object.defineProperty(Object.prototype, '$k', {
    value: function () {
        return Object.keys(this)
    }
});
Object.defineProperty(Object.prototype, '$v', {
    value: function () {
        return Object.values(this)
    }
});
Object.defineProperty(Object.prototype, '$kv', {
    value: function () {
        return Object.entries(this)
    }
});
Array.prototype.sum = function (fn) {
    return this.reduce((p, v) => p + (fn ? fn(v) : v), 0)
};
Array.prototype.uniq = function (fn) {
    let set = new Set();
    return this.filter(v => {
        let newValue = !set.has(fn ? fn(v) : v);
        set.add(fn ? fn(v) : v);
        return newValue;
    });
};
Array.prototype.toObj = function (fn) {
    return this.map(v => fn ? fn(v) : v).reduce((p, v) => {
        p[v[0]] = v[1];
        return p;
    }, {})
};
Array.prototype.min = function (fn) {
    let min = 1e20, index = -1, x;
    for (let i = 0; i < this.length; i++) {
        x = fn ? fn(this[i], i, this) : this[i];
        if (x < min) {
            min = x;
            index = i
        }
    }
    return [this[index], index, min];
};
Array.prototype.max = function (fn) {
    let max = -1e20, index = -1, x;
    for (let i = 0; i < this.length; i++) {
        x = fn ? fn(this[i], i, this) : this[i];
        if (x > max) {
            max = x;
            index = i
        }
    }
    return [this[index], index, max];
};
Array.prototype.rev = function (first, last) {
    for (let i = first; i < (first + last) / 2; i++) {
        [this[i], this[last - 1 - i + first]] = [this[last - 1 - i + first], this[i]]
    }
};
Array.prototype.set = function (pos, arr) {
    for (let i = pos; i < pos + arr.length; i++) {
        this[i] = arr[i - pos];
    }
};
Array.prototype.for = function (a, b, fn) {
    let res;
    for (let i = a; i <= b; i++) {
        if ((res = fn(this[i], i, this)) != null) return res;
    }
};
Array.prototype.forR = function (a, b, fn) {
    let res
    for (let i = a; i >= b; i--) {
        if ((res = fn(this[i], i, this)) != null) return res;
    }
};

function gcd(a, b) {
    while (b) [a, b] = [b, a % b];
    return a;
}

function mul(a, b, m) {
    return ((a >> 16) * b % m * 65536 + (a & 65535) * b) % m
}

function pow(a, n, m) {
    let r = 1;
    while (n) n & 1 ? (r = mul(r, a, m), n--) : [a, n] = [mul(a, a, m), n >> 1]
    return r;
}

let MOD = 998244353;

function inv(b) {
    for (let a = MOD, u = 0, v = 1, t; b; v = t)
        (t = a / b | 0, a -= t * b, u -= t * v, t = a, a = b, b = t, t = u, u = v);
    return (u + MOD) % MOD;
}

let input = '';
process.stdin.on('data', c => input += c);
process.stdin.on('end', main);

/**
 * Accepted --- 327ms
 */
function main() {
    let inp = input.split(/\s+/).map(v => +v), _i = 0, $ = n => n != null ? inp.slice(_i, _i += n) : inp[_i++],
        out = [], log = console.log, asc = (a, b) => a - b, desc = (a, b) => b - a, min = Math.min, max = Math.max,
        abs = Math.abs;

    let [n, k] = $(2), h = $(n), tree = new AVLTree();
    tree.insert(h[0]);
    let Max = 1;
    let allRes = [];
    let i = 0, j = 0;
    while (i < n) {
        while (j < n) {
            j++;
            if (!h[j]) break;
            tree.insert(h[j]);
            if (tree.max() - tree.min() > k) break;
        }
        if (Max < j - i) {
            Max = j - i;
            allRes = [(i + 1) + ' ' + j];
        } else if (Max == j - i) {
            allRes.push((i + 1) + ' ' + j);
        }
        Max = max(j - i, Max);
        tree.remove(h[i++]);
        while (tree.max() - tree.min() > k) {
            tree.remove(h[i++]);
        }
    }
    log(Max, allRes.length);
    log(allRes.join('\n'));
}



let AVLTree = (function () {
    function print(root, printNode) {
        if (printNode === void 0) printNode = function (n) {
            return n.key;
        };

        let out = [];
        row(root, '', true, function (v) {
            return out.push(v);
        }, printNode);
        return out.join('');
    }

    function isBalanced(root) {
        if (root === null) {
            return true;
        }
        let lh = height(root.left);
        let rh = height(root.right);
        if (Math.abs(lh - rh) <= 1 &&
            isBalanced(root.left) &&
            isBalanced(root.right)) {
            return true;
        }
        return false;
    }

    function height(node) {
        return node ? (1 + Math.max(height(node.left), height(node.right))) : 0;
    }

    function loadRecursive(parent, keys, values, start, end) {
        let size = end - start;
        if (size > 0) {
            let middle = start + Math.floor(size / 2);
            let key = keys[middle];
            let data = values[middle];
            let node = { key: key, data: data, parent: parent };
            node.left = loadRecursive(node, keys, values, start, middle);
            node.right = loadRecursive(node, keys, values, middle + 1, end);
            return node;
        }
        return null;
    }

    function markBalance(node) {
        if (node === null) {
            return 0;
        }
        let lh = markBalance(node.left);
        let rh = markBalance(node.right);

        node.balanceFactor = lh - rh;
        return Math.max(lh, rh) + 1;
    }

    function sort(keys, values, left, right, compare) {
        if (left >= right) {
            return;
        }
        let pivot = keys[(left + right) >> 1];
        let i = left - 1;
        let j = right + 1;
        while (true) {
            do {
                i++;
            } while (compare(keys[i], pivot) < 0);
            do {
                j--;
            } while (compare(keys[j], pivot) > 0);
            if (i >= j) {
                break;
            }
            let tmp = keys[i];
            keys[i] = keys[j];
            keys[j] = tmp;

            tmp = values[i];
            values[i] = values[j];
            values[j] = tmp;
        }

        sort(keys, values, left, j, compare);
        sort(keys, values, j + 1, right, compare);
    }

    function DEFAULT_COMPARE(a, b) {
        return a > b ? 1 : a < b ? -1 : 0;
    }

    function rotateLeft(node) {
        let rightNode = node.right;
        node.right = rightNode.left;

        if (rightNode.left) {
            rightNode.left.parent = node;
        }

        rightNode.parent = node.parent;
        if (rightNode.parent) {
            if (rightNode.parent.left === node) {
                rightNode.parent.left = rightNode;
            } else {
                rightNode.parent.right = rightNode;
            }
        }

        node.parent = rightNode;
        rightNode.left = node;

        node.balanceFactor += 1;
        if (rightNode.balanceFactor < 0) {
            node.balanceFactor -= rightNode.balanceFactor;
        }

        rightNode.balanceFactor += 1;
        if (node.balanceFactor > 0) {
            rightNode.balanceFactor += node.balanceFactor;
        }
        return rightNode;
    }

    function rotateRight(node) {
        let leftNode = node.left;
        node.left = leftNode.right;
        if (node.left) {
            node.left.parent = node;
        }

        leftNode.parent = node.parent;
        if (leftNode.parent) {
            if (leftNode.parent.left === node) {
                leftNode.parent.left = leftNode;
            } else {
                leftNode.parent.right = leftNode;
            }
        }

        node.parent = leftNode;
        leftNode.right = node;

        node.balanceFactor -= 1;
        if (leftNode.balanceFactor > 0) {
            node.balanceFactor -= leftNode.balanceFactor;
        }

        leftNode.balanceFactor -= 1;
        if (node.balanceFactor < 0) {
            leftNode.balanceFactor += node.balanceFactor;
        }

        return leftNode;
    }

    let AVLTree = function AVLTree(comparator, noDuplicates) {
        if (noDuplicates === void 0) noDuplicates = false;

        this._comparator = comparator || DEFAULT_COMPARE;
        this._root = null;
        this._size = 0;
        this._noDuplicates = !!noDuplicates;
    };

    let prototypeAccessors = { size: { configurable: true } };

    AVLTree.prototype.destroy = function destroy() {
        return this.clear();
    };

    AVLTree.prototype.clear = function clear() {
        this._root = null;
        this._size = 0;
        return this;
    };

    prototypeAccessors.size.get = function () {
        return this._size;
    };

    AVLTree.prototype.contains = function contains(key) {
        if (this._root) {
            let node = this._root;
            let comparator = this._comparator;
            while (node) {
                let cmp = comparator(key, node.key);
                if (cmp === 0) {
                    return true;
                } else if (cmp < 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        return false;
    };

    AVLTree.prototype.next = function next(node) {
        let successor = node;
        if (successor) {
            if (successor.right) {
                successor = successor.right;
                while (successor.left) {
                    successor = successor.left;
                }
            } else {
                successor = node.parent;
                while (successor && successor.right === node) {
                    node = successor;
                    successor = successor.parent;
                }
            }
        }
        return successor;
    };

    AVLTree.prototype.prev = function prev(node) {
        let predecessor = node;
        if (predecessor) {
            if (predecessor.left) {
                predecessor = predecessor.left;
                while (predecessor.right) {
                    predecessor = predecessor.right;
                }
            } else {
                predecessor = node.parent;
                while (predecessor && predecessor.left === node) {
                    node = predecessor;
                    predecessor = predecessor.parent;
                }
            }
        }
        return predecessor;
    };


    AVLTree.prototype.forEach = function forEach(callback) {
        let current = this._root;
        let s = [], done = false, i = 0;
        while (!done) {
            if (current) {
                s.push(current);
                current = current.left;
            } else {
                if (s.length > 0) {
                    current = s.pop();
                    callback(current, i++);
                    current = current.right;
                } else {
                    done = true;
                }
            }
        }
        return this;
    };

    AVLTree.prototype.range = function range(low, high, fn, ctx) {
        let this$1 = this;
        let Q = [];
        let compare = this._comparator;
        let node = this._root, cmp;
        while (Q.length !== 0 || node) {
            if (node) {
                Q.push(node);
                node = node.left;
            } else {
                node = Q.pop();
                cmp = compare(node.key, high);
                if (cmp > 0) {
                    break;
                } else if (compare(node.key, low) >= 0) {
                    if (fn.call(ctx, node)) {
                        return this$1;
                    }
                }
                node = node.right;
            }
        }
        return this;
    };

    AVLTree.prototype.keys = function keys() {
        let current = this._root;
        let s = [], r = [], done = false;
        while (!done) {
            if (current) {
                s.push(current);
                current = current.left;
            } else {
                if (s.length > 0) {
                    current = s.pop();
                    r.push(current.key);
                    current = current.right;
                } else {
                    done = true;
                }
            }
        }
        return r;
    };

    AVLTree.prototype.values = function values() {
        let current = this._root;
        let s = [], r = [], done = false;
        while (!done) {
            if (current) {
                s.push(current);
                current = current.left;
            } else {
                if (s.length > 0) {
                    current = s.pop();
                    r.push(current.data);
                    current = current.right;
                } else {
                    done = true;
                }
            }
        }
        return r;
    };

    AVLTree.prototype.at = function at(index) {
        let current = this._root;
        let s = [], done = false, i = 0;
        while (!done) {
            if (current) {
                s.push(current);
                current = current.left;
            } else {
                if (s.length > 0) {
                    current = s.pop();
                    if (i === index) {
                        return current;
                    }
                    i++;
                    current = current.right;
                } else {
                    done = true;
                }
            }
        }
        return null;
    };

    AVLTree.prototype.minNode = function minNode() {
        let node = this._root;
        if (!node) {
            return null;
        }
        while (node.left) {
            node = node.left;
        }
        return node;
    };

    AVLTree.prototype.maxNode = function maxNode() {
        let node = this._root;
        if (!node) {
            return null;
        }
        while (node.right) {
            node = node.right;
        }
        return node;
    };

    AVLTree.prototype.min = function min() {
        let node = this._root;
        if (!node) {
            return null;
        }
        while (node.left) {
            node = node.left;
        }
        return node.key;
    };

    AVLTree.prototype.max = function max() {
        let node = this._root;
        if (!node) {
            return null;
        }
        while (node.right) {
            node = node.right;
        }
        return node.key;
    };

    AVLTree.prototype.isEmpty = function isEmpty() {
        return !this._root;
    };

    AVLTree.prototype.pop = function pop() {
        let node = this._root, returnValue = null;
        if (node) {
            while (node.left) {
                node = node.left;
            }
            returnValue = { key: node.key, data: node.data };
            this.remove(node.key);
        }
        return returnValue;
    };

    AVLTree.prototype.find = function find(key) {
        let root = this._root;
        let subtree = root, cmp;
        let compare = this._comparator;
        while (subtree) {
            cmp = compare(key, subtree.key);
            if (cmp === 0) {
                return subtree;
            } else if (cmp < 0) {
                subtree = subtree.left;
            } else {
                subtree = subtree.right;
            }
        }

        return null;
    };

    AVLTree.prototype.insert = function insert(key, data) {
        let this$1 = this;
        if (!this._root) {
            this._root = {
                parent: null, left: null, right: null, balanceFactor: 0,
                key: key, data: data
            };
            this._size++;
            return this._root;
        }

        let compare = this._comparator;
        let node = this._root;
        let parent = null;
        let cmp = 0;

        if (this._noDuplicates) {
            while (node) {
                cmp = compare(key, node.key);
                parent = node;
                if (cmp === 0) {
                    return null;
                } else if (cmp < 0) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        } else {
            while (node) {
                cmp = compare(key, node.key);
                parent = node;
                if (cmp <= 0) {
                    node = node.left;
                } //return null;
                else {
                    node = node.right;
                }
            }
        }

        let newNode = {
            left: null,
            right: null,
            balanceFactor: 0,
            parent: parent, key: key, data: data
        };
        let newRoot;
        if (cmp <= 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        while (parent) {
            cmp = compare(parent.key, key);
            if (cmp < 0) {
                parent.balanceFactor -= 1;
            } else {
                parent.balanceFactor += 1;
            }

            if (parent.balanceFactor === 0) {
                break;
            } else if (parent.balanceFactor < -1) {
                if (parent.right.balanceFactor === 1) {
                    rotateRight(parent.right);
                }
                newRoot = rotateLeft(parent);
                if (parent === this$1._root) {
                    this$1._root = newRoot;
                }
                break;
            } else if (parent.balanceFactor > 1) {
                if (parent.left.balanceFactor === -1) {
                    rotateLeft(parent.left);
                }
                newRoot = rotateRight(parent);

                if (parent === this$1._root) {
                    this$1._root = newRoot;
                }
                break;
            }
            parent = parent.parent;
        }

        this._size++;
        return newNode;
    };

    AVLTree.prototype.remove = function remove(key) {
        let this$1 = this;
        if (!this._root) {
            return null;
        }
        let node = this._root;
        let compare = this._comparator;
        let cmp = 0;
        while (node) {
            cmp = compare(key, node.key);
            if (cmp === 0) {
                break;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (!node) {
            return null;
        }

        let returnValue = node.key;
        let max, min;

        if (node.left) {
            max = node.left;

            while (max.left || max.right) {
                while (max.right) {
                    max = max.right;
                }

                node.key = max.key;
                node.data = max.data;
                if (max.left) {
                    node = max;
                    max = max.left;
                }
            }

            node.key = max.key;
            node.data = max.data;
            node = max;
        }

        if (node.right) {
            min = node.right;

            while (min.left || min.right) {
                while (min.left) {
                    min = min.left;
                }

                node.key = min.key;
                node.data = min.data;
                if (min.right) {
                    node = min;
                    min = min.right;
                }
            }

            node.key = min.key;
            node.data = min.data;
            node = min;
        }

        let parent = node.parent;
        let pp = node;
        let newRoot;

        while (parent) {
            if (parent.left === pp) {
                parent.balanceFactor -= 1;
            } else {
                parent.balanceFactor += 1;
            }

            if (parent.balanceFactor < -1) {
                if (parent.right.balanceFactor === 1) {
                    rotateRight(parent.right);
                }
                newRoot = rotateLeft(parent);

                if (parent === this$1._root) {
                    this$1._root = newRoot;
                }
                parent = newRoot;
            } else if (parent.balanceFactor > 1) {
                if (parent.left.balanceFactor === -1) {
                    rotateLeft(parent.left);
                }
                newRoot = rotateRight(parent);
                if (parent === this$1._root) {
                    this$1._root = newRoot;
                }
                parent = newRoot;
            }
            if (parent.balanceFactor === -1 || parent.balanceFactor === 1) {
                break;
            }
            pp = parent;
            parent = parent.parent;
        }

        if (node.parent) {
            if (node.parent.left === node) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        }

        if (node === this._root) {
            this._root = null;
        }

        this._size--;
        return returnValue;
    };

    AVLTree.prototype.load = function load(keys, values, presort) {
        if (keys === void 0) keys = [];
        if (values === void 0) values = [];

        if (this._size !== 0) {
            throw new Error('bulk-load: tree is not empty');
        }
        let size = keys.length;
        if (presort) {
            sort(keys, values, 0, size - 1, this._comparator);
        }
        this._root = loadRecursive(null, keys, values, 0, size);
        markBalance(this._root);
        this._size = size;
        return this;
    };

    AVLTree.prototype.isBalanced = function isBalanced$1() {
        return isBalanced(this._root);
    };

    AVLTree.prototype.toString = function toString(printNode) {
        return print(this._root, printNode);
    };

    Object.defineProperties(AVLTree.prototype, prototypeAccessors);

    AVLTree.default = AVLTree;

    return AVLTree;

})();
