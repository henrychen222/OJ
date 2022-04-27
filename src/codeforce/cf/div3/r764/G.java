/**
 * 01/10/22 morning
 * https://codeforces.com/contest/1624/problem/G
 */
package codeforce.cf.div3.r764;

import java.util.*;
import java.io.*;

public class G {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1624/submission/142305825
    // reference: neal
    void solve(int n, int m, int[][] edges) {
        // tr(edges);
        List<Node> g = new ArrayList<>();
        packUGCost(g, edges);
        // debug(g);
        int res = 0;
        for (int i = 29; i >= 0; i--) {
            int remove = (1 << i) - 1;
            DJSet ds = new DJSet(n);
            for (Node node : g) {
                int u = node.u, v = node.v, weight = node.weight;
                if (((weight & ~remove) | res) == res && (weight >> i & 1) == 0) {
                    ds.union(u, v);
                }
            }
            // tr("group", ds.components, "count", ds.count());
            // if (ds.components > 1) {
            if (ds.count() > 2) { // Accepted --- https://codeforces.com/contest/1624/submission/153998748 (04/18/22 morning)
                res |= 1 << i;
            }
        }
        pr(res);
    }

    void debug(List<Node> g) {
        int n = g.size();
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) {
            Node node = g.get(i);
            res[i] = new int[]{node.u, node.v, node.weight};
        }
        tr(res);
    }

    void packUGCost(List<Node> g, int[][] edges) {
        for (int[] a : edges) {
            int u = a[0], v = a[1], cost = a[2];
            g.add(new Node(u - 1, v - 1, cost));
        }
    }

    class Node {
        int u;
        int v;
        int weight;

        Node(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    class DJSet {
        int[] parent;
        int components; // group trace

        DJSet(int n) {
            parent = new int[n + 1];
            Arrays.fill(this.parent, -1);
            components = n;
        }

        public int find(int x) {
            return parent[x] < 0 ? x : (parent[x] = find(parent[x]));
        }

//        public boolean union(int x, int y) {
//            x = find(x);
//            y = find(y);
//            if (x == y) return false;
//            if (-parent[x] < -parent[y]) {
//                int d = x;
//                x = y;
//                y = d;
//            }
//            parent[x] += parent[y];
//            parent[y] = x;
//            components--;
//            return true;
//        }

        // Accepted --- https://codeforces.com/contest/1624/submission/153990308 (04/18/22 morning rewrite union() consistent with uwi's)
        // Accepted --- https://codeforces.com/contest/1624/submission/153991938 (04/18/22 morning)
        public boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                // if (parent[x] > parent[y]) {
                if (parent[x] < parent[y]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                parent[x] += parent[y];
                parent[y] = x;
                components--;
            }
            return x == y;
        }

        boolean equiv(int x, int y) {
            return find(x) == find(y);
        }

        int count() {
            int cnt = 0;
            for (int u : parent) if (u < 0) cnt++;
            return cnt;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            int[][] edges = new int[m][];
            for (int i = 0; i < m; i++) edges[i] = fs.readArray(3);
            solve(n, m, edges);
        }
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
        new G().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}