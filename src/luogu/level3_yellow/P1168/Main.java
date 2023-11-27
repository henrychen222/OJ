/**
 * 10/26/23 afternoon
 * https://www.luogu.com.cn/problem/P1168
 */
package luogu.level3_yellow.P1168;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    // https://www.luogu.com.cn/record/131698824
    // https://www.luogu.com.cn/record/131629736 (JS)
    void solve(int n, int[] a) {
        SplayTree tree = new SplayTree();
        for (int i = 0; i < n; i++) {
            tree.insert(a[i]);
            if (i % 2 == 0) pr(tree.findKth(i / 2));
        }
    }

    class SplayNode {
        SplayNode parent, left, right;
        int val, sz;
        long sum;

        SplayNode(int value) {
            this.parent = null;
            this.left = null;
            this.right = null;
            this.val = value;
            this.sum = value;
            this.sz = 1;
        }

        void update() {
            this.sz = (this.left != null ? this.left.sz : 0) + (this.right != null ? this.right.sz : 0) + 1;
            this.sum = (this.left != null ? this.left.sum : 0) + (this.right != null ? this.right.sum : 0) + this.val;
        }

        boolean isLeft() {
            return this.parent != null && this.parent.left == this;
        }

        boolean isRight() {
            return this.parent != null && this.parent.right == this;
        }

        boolean isRoot(SplayNode guard) {
            return this.parent == guard;
        }
    }

    class SplayTree {
        SplayNode root;

        SplayTree() {
            this.root = null;
        }

        int cmp(int x, int y) {
            return x >= y ? 0 : 1;
        }

        void zig(SplayNode x) { // right rotation
            SplayNode y = x.parent;
            if (x.right != null) x.right.parent = y;
            y.left = x.right;
            x.right = y;
            if (y.isLeft()) {
                y.parent.left = x;
            } else if (y.isRight()) {
                y.parent.right = x;
            }
            x.parent = y.parent;
            y.parent = x;
            y.update();
            x.update();
        }

        void zag(SplayNode x) { // left rotation
            SplayNode y = x.parent;
            if (x.left != null) x.left.parent = y;
            y.right = x.left;
            x.left = y;
            if (y.isLeft()) {
                y.parent.left = x;
            } else if (y.isRight()) {
                y.parent.right = x;
            }
            x.parent = y.parent;
            y.parent = x;
            y.update();
            x.update();
        }

        void zigzig(SplayNode x) { // RR
            this.zig(x.parent);
            this.zig(x);
        }

        void zigzag(SplayNode x) { // RL
            this.zig(x);
            this.zag(x);
        }

        void zagzag(SplayNode x) { // LL
            this.zag(x.parent);
            this.zag(x);
        }

        void zagzig(SplayNode x) { // LR
            this.zag(x);
            this.zig(x);
        }

        void splay(SplayNode node, SplayNode guard) { // splay node under guard, default splay to root
            while (!node.isRoot(guard)) {
                if (node.parent.isRoot(guard)) {
                    if (node.isLeft()) {
                        this.zig(node);
                    } else {
                        this.zag(node);
                    }
                } else {
                    if (node.parent.isLeft()) {
                        if (node.isLeft()) {
                            this.zigzig(node);
                        } else {
                            this.zagzig(node);
                        }
                    } else {
                        if (node.isRight()) {
                            this.zagzag(node);
                        } else {
                            this.zigzag(node);
                        }
                    }
                }
            }
            if (guard == null) this.root = node;
        }

        SplayNode LastNode(SplayNode x) {
            this.splay(x, null);
            SplayNode node = x.left;
            if (node == null) return null;
            while (node.right != null) node = node.right;
            this.splay(node, null);
            return node;
        }

        SplayNode NextNode(SplayNode x) {
            this.splay(x, null);
            SplayNode node = x.right;
            if (node == null) return null;
            while (node.left != null) node = node.left;
            this.splay(node, null);
            return node;
        }

        SplayNode find(int value) {
            return this.findFirstOf(value);
        }

        SplayNode findFirstOf(int value) {
            SplayNode node = this.root, res = null, last_visited = null;
            while (node != null) {
                last_visited = node;
                if (this.cmp(value, node.val) > 0) {
                    node = node.left;
                } else if (this.cmp(node.val, value) > 0) {
                    node = node.right;
                } else {
                    res = node;
                    node = node.left;
                }
            }
            if (last_visited != null) this.splay(last_visited, null);
            return res;
        }

        SplayNode findLastOf(int value) {
            SplayNode node = this.root, res = null, last_visited = null;
            while (node != null) {
                last_visited = node;
                if (this.cmp(value, node.val) > 0) {
                    node = node.left;
                } else if (this.cmp(node.val, value) > 0) {
                    node = node.right;
                } else {
                    res = node;
                    node = node.right;
                }
            }
            if (last_visited != null) this.splay(last_visited, null);
            return res;
        }

        int findRankOf(SplayNode node) {
            this.splay(node, null);
            return node.left == null ? 0 : node.left.sz;
        }

        SplayNode findSuccessorOf(int value) {
            SplayNode node = this.root, res = null, last_visited = null;
            while (node != null) {
                last_visited = node;
                if (this.cmp(value, node.val) > 0) {
                    res = node;
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            if (last_visited != null) this.splay(last_visited, null);
            return res;
        }

        SplayNode findPrecursorOf(int value) {
            SplayNode node = this.root, res = null, last_visited = null;
            while (node != null) {
                last_visited = node;
                if (this.cmp(node.val, value) > 0) {
                    res = node;
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
            if (last_visited != null) this.splay(last_visited, null);
            return res;
        }

        SplayNode findKthNode(int rank) {
            if (rank < 0 || rank >= this.size()) return null;
            SplayNode node = this.root;
            while (node != null) {
                int leftsize = node.left == null ? 0 : node.left.sz;
                if (leftsize == rank) break;
                if (leftsize > rank) {
                    node = node.left;
                } else {
                    rank -= leftsize + 1;
                    node = node.right;
                }
            }
            this.splay(node, null);
            return node;
        }

        SplayNode make(int value) {
            return new SplayNode(value);
        }

        void removeNode(SplayNode node) {
            node = null;
        }

        // -------------------------------- Public Usage --------------------------------------
        SplayNode insert(int value) { // allow duplicates  LST.set()
            if (this.root == null) {
                this.root = this.make(value);
                return this.root;
            }
            SplayNode node = this.root;
            while (node != null) {
                if (this.cmp(value, node.val) > 0) {
                    if (node.left == null) {
                        node.left = this.make(value);
                        node.left.parent = node;
                        node = node.left;
                        break;
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = this.make(value);
                        node.right.parent = node;
                        node = node.right;
                        break;
                    }
                    node = node.right;
                }
            }
            this.splay(node, null);
            return node;
        }

        boolean remove(int value) { // remove one node, not all   LST.unset()
            SplayNode node = this.find(value);
            if (node == null) return false;
            this.splay(node, null);
            if (node.left == null) {
                this.root = node.right;
                if (node.right != null) node.right.parent = null;
                this.removeNode(node);
                return true;
            }
            if (node.right == null) {
                this.root = node.left;
                if (node.left != null) node.left.parent = null;
                this.removeNode(node);
                return true;
            }
            SplayNode last_node = this.LastNode(node);
            SplayNode next_node = this.NextNode(node);
            this.splay(last_node, null);
            this.splay(next_node, last_node);
            this.removeNode(next_node.left);
            next_node.left = null;
            next_node.update();
            last_node.update();
            return true;
        }

        boolean has(int value) { // LST.get()
            return this.count(value) > 0;
        }

        int count(int value) {
            SplayNode x = this.findFirstOf(value);
            if (x == null) return 0;
            int rank_x = this.findRankOf(x);
            SplayNode y = this.findLastOf(value);
            int rank_y = this.findRankOf(y);
            return rank_y - rank_x + 1;
        }

        int rankOf(int value) { // The number of elements strictly less than value
            SplayNode x = this.findPrecursorOf(value);
            return x == null ? 0 : this.findRankOf(x) + 1;
        }

        Integer findKth(int rank) { // (0-indexed)
            SplayNode x = this.findKthNode(rank);
            return x == null ? null : (x.val);
        }

        Integer higher(int value) { // > upper_bound()  LST.next(value)
            SplayNode node = this.findSuccessorOf(value);
            return node == null ? null : (node.val);
        }

        Integer lower(int value) { // <  LST.prev(value - 1)
            SplayNode node = this.findPrecursorOf(value);
            return node == null ? null : (node.val);
        }

        Integer ceiling(int value) { // >=
            return this.has(value) ? value : this.higher(value);
        }

        Integer floor(int value) { // <=
            return this.has(value) ? value : this.lower(value);
        }

        Integer first() {
            return this.findKth(0);
        }

        Integer last() {
            return this.findKth(this.size() - 1);
        }

        Integer poll() {
            Integer res = this.first();
            this.remove(res);
            return res;
        }

        Integer pollLast() {
            Integer res = this.last();
            this.remove(res);
            return res;
        }

        int size() {
            return this.root == null ? 0 : this.root.sz;
        }

        boolean isEmpty() {
            return this.root == null;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
    }

    private final String INPUT = "input.txt";
    private final String OUTPUT = "output.txt";

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            instream = new FileInputStream(INPUT);
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Main().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}

