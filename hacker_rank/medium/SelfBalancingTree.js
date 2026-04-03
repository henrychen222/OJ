/**
 * 01/14/23 night
 * https://www.hackerrank.com/challenges/self-balancing-tree/
 */

const pr = console.log;

class AVLNode {
    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.height = 1;
        this.cnt = 1;
    }
}

class AVLTree {
    constructor() {
        this.root = null;
    }
    getHeight(node) {
        return node != null ? node.height : 0;
    }
    getBalance(node) {
        return node != null ? this.getHeight(node.left) - this.getHeight(node.right) : 0;
    }
    LR(z) {
        let y = z.right;
        let T2 = y.left;
        y.left = z;
        z.right = T2;
        z.height = 1 + Math.max(this.getHeight(z.left), this.getHeight(z.right));
        y.height = 1 + Math.max(this.getHeight(y.left), this.getHeight(y.right));
        return y;
    }
    RR(z) {
        let y = z.left;
        let T3 = y.right;
        y.right = z
        z.left = T3
        z.height = 1 + Math.max(this.getHeight(z.left), this.getHeight(z.right));
        y.height = 1 + Math.max(this.getHeight(y.left), this.getHeight(y.right));
        return y;
    }
    insert(v) {
        this.root = this.insertUtil(this.root, v);
        // printTree(this.root)
    }
    insertUtil(node, v) {
        if (node == null) {
            return new AVLNode(v);
        } else if (v < node.val) {
            node.left = this.insertUtil(node.left, v);
        } else if (v > node.val) {
            node.right = this.insertUtil(node.right, v);
        } else {
            node.cnt++;
            return node;
        }
        node.height = 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right));
        let bal = this.getBalance(node);
        if (bal > 1 && v < node.left.val) return this.RR(node);
        if (bal > 1 && v > node.left.val) {
            node.left = this.LR(node.left);
            return this.RR(node);
        }
        if (bal < -1 && v > node.right.val) return this.LR(node);
        if (bal < -1 && v < node.right.val) {
            node.right = this.RR(node.right);
            return this.LR(node);
        }
        return node;
    }
    remove(v) {
        this.root = this.removeUtil(this.root, v);
    }
    removeUtil(node, v) {
        if (node == null) {
            return node;
        } else if (v < node.val) {
            node.left = this.removeUtil(node.left, v);
        } else if (v > node.val) {
            node.right = this.removeUtil(node.right, v);
        } else {
            if (node.cnt > 1) {
                node.cnt--;
                return node;
            }
            if (node.left == null) {
                let tmp = node.right;
                node = null;
                return tmp;
            } else if (node.right == null) {
                let tmp = node.left;
                node = null;
                return tmp;
            }
            let tmp = this.findMin(node.right);
            node.val = tmp.val;
            node.right = this.removeUtil(node.right, tmp.val);
        }
        if (node == null) return node;
        node.height = 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right));
        let bal = this.getBalance(node);
        if (bal > 1 && this.getBalance(node.left) >= 0) return this.RR(node);
        if (bal < -1 && this.getBalance(node.right) <= 0) return this.LR(node);
        if (bal > 1 && this.getBalance(node.left) < 0) {
            node.left = this.LR(node.left);
            return this.RR(node);
        }
        if (bal < -1 && this.getBalance(node.right) > 0) {
            node.right = this.RR(node.right);
            return this.LR(node);
        }
        return node;
    }
    FindFirstOf(value) {
        let node = this.root, res = null;
        while (node != null) {
            if (value < node.val) {
                node = node.left;
            } else if (value > node.val) {
                node = node.right;
            } else {
                res = node;
                node = node.left;
            }
        }
        return res;
    }
    FindLastOf(value) {
        let node = this.root, res = null;
        while (node != null) {
            if (value < node.val) {
                node = node.left;
            } else if (value > node.val) {
                node = node.right;
            } else {
                res = node;
                node = node.right;
            }
        }
        return res;
    }
    maxx() {
        let node = this.findMax(this.root);
        return node == null ? null : node.val;
    }
    minx() {
        let node = this.findMin(this.root);
        return node == null ? null : node.val;
    }
    findMin(node) {
        return node == null || node.left == null ? node : this.findMin(node.left);
    }
    findMax(node) {
        return node == null || node.right == null ? node : this.findMax(node.right);
    }
    preOrder_DFS() {
        let d = [];
        this.dfs(this.root, d);
        return d;
    }
    dfs(node, d) {
        if (!node) return;
        d.push(node.val);
        this.dfs(node.left, d);
        this.dfs(node.right, d);
    }
}

// Accepted --- https://www.hackerrank.com/challenges/self-balancing-tree/submissions/code/309616397 (FindLastOf)
// Accepted --- https://www.hackerrank.com/challenges/self-balancing-tree/submissions/code/309616667 (FindFirstOf)
// Accepted --- https://www.hackerrank.com/challenges/self-balancing-tree/submissions/code/309617536 (rename preorder)
let tree;
const solve = (n, a, v) => {
    tree = new AVLTree();
    for (const x of a) tree.insert(x);
    a.push(v);
    tree.insert(v);
    op(a);
};

const op = (a) => {
    let res = [], orderPrint = [], m = new Map();
    for (const x of a) {
        // FindFirstOf FindLastOf both works
        let node = tree.FindFirstOf(x), bal = tree.getBalance(node), s = `${x}(BF=${bal})`;
        // pr(x, "node", node.val, bal)
        m.set(x, s);
        orderPrint.push([x, s])
    }
    orderPrint.sort((x, y) => x[0] - y[0]);
    pr(orderPrint.map(x => x[1]).join(" "));
    let preorder = tree.preOrder_DFS();
    for (const x of preorder) res.push(m.get(x));
    pr(res.join(" "));
};

const printTree = (root) => { // level order bfs with null
    let q = [root], a = [];
    while (q.length) {
        let cur = q.shift();
        a.push(cur != null ? cur.val : null);
        if (cur != null) {
            q.push(cur.left);
            q.push(cur.right);
        }
    }
    while (a[a.length - 1] == null) a.pop();
    console.log(JSON.stringify(a));
};

const main = () => {
    const readLine = () => input[currentLine++];
    const ni = () => readLine() - '0';
    const nas = () => readLine().split(" ");
    const nai = () => nas().map(Number);
    const nal = () => nas().map(BigInt);
    let input = '', currentLine = 0;
    process.stdin.on('data', (stdin) => input += stdin)
    process.stdin.on('end', () => {
        input = input.split('\n');
        let n = ni(), a = nai(), v = ni();
        solve(n, a, v);
    });
};

main()