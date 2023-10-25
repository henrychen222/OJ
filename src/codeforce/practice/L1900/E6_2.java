/**
 * 01/15/23 morning
 * https://codeforces.com/problemset/problem/6/E
 */
package codeforce.practice.L1900;

import java.util.*;
import java.io.*;

// Use AVL Tree
public class E6_2 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/6/submission/189347431

    // WA --- https://codeforces.com/contest/6/submission/189352161 (TreeSet single value problem, Pair works)
    // Accepted --- https://codeforces.com/contest/6/submission/189357792 (insert duplicates)
    void solve(int n, int k, int[] h) {
        int max = 1;
        AVLTree tree = new AVLTree();
        List<String> res = new ArrayList<>();
        tree.insert(h[0]);
        int r = 0;
        for (int i = 0; i < n; ) {
            while (r < n) {
                r++;
                if (r >= n) break;
                tree.insert(h[r]);
                if (tree.maxx() - tree.minx() > k) break;
            }
            if (max < r - i) {
                max = r - i;
                res.clear();
                res.add((i + 1) + " " + r);
            } else if (max == r - i) {
                res.add((i + 1) + " " + r);
            }
            max = Math.max(max, r - i);
            tree.remove(h[i++]);
            while (tree.maxx() - tree.minx() > k) tree.remove(h[i++]);
        }
        pr(max + " " + res.size());
        for (String e : res) pr(e);
    }

    class AVLNode {
        int val, height, cnt;
        AVLNode left, right;

        AVLNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.height = 1;
            this.cnt = 1;
        }
    }

    class AVLTree {
        AVLNode root;

        AVLTree() {
            this.root = null;
        }

        int getHeight(AVLNode node) {
            return node != null ? node.height : 0;
        }

        int getBalance(AVLNode node) {
            return node != null ? this.getHeight(node.left) - this.getHeight(node.right) : 0;
        }

        AVLNode LR(AVLNode z) {
            AVLNode y = z.right;
            AVLNode T2 = y.left;
            y.left = z;
            z.right = T2;
            z.height = 1 + Math.max(this.getHeight(z.left), this.getHeight(z.right));
            y.height = 1 + Math.max(this.getHeight(y.left), this.getHeight(y.right));
            return y;
        }

        AVLNode RR(AVLNode z) {
            AVLNode y = z.left;
            AVLNode T3 = y.right;
            y.right = z;
            z.left = T3;
            z.height = 1 + Math.max(this.getHeight(z.left), this.getHeight(z.right));
            y.height = 1 + Math.max(this.getHeight(y.left), this.getHeight(y.right));
            return y;
        }

        void insert(int v) {
            this.root = this.insertUtil(this.root, v);
        }

        AVLNode insertUtil(AVLNode node, int v) {
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
            int bal = this.getBalance(node);
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

        void remove(int v) {
            this.root = this.removeUtil(this.root, v);
        }

        AVLNode removeUtil(AVLNode node, int v) {
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
                    AVLNode tmp = node.right;
                    node = null;
                    return tmp;
                } else if (node.right == null) {
                    AVLNode tmp = node.left;
                    node = null;
                    return tmp;
                }
                AVLNode tmp = this.findMin(node.right);
                node.val = tmp.val;
                node.right = this.removeUtil(node.right, tmp.val);
            }
            if (node == null) return node;
            node.height = 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right));
            int bal = this.getBalance(node);
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

        int maxx() {
            AVLNode node = this.findMax(this.root);
            return node == null ? -1 : node.val;
        }

        int minx() {
            AVLNode node = this.findMin(this.root);
            return node == null ? -1 : node.val;
        }

        AVLNode findMin(AVLNode node) {
            return node == null || node.left == null ? node : this.findMin(node.left);
        }

        AVLNode findMax(AVLNode node) {
            return node == null || node.right == null ? node : this.findMax(node.right);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] h = fs.readArray(n);
        solve(n, k, h);
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
        new E6_2().run();
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