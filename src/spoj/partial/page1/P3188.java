/**
 * 04/19/26 evening
 * https://www.spoj.com/problems/MST/
 * reference:
 * https://www.geeksforgeeks.org/dsa/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
 * https://cp-algorithms.com/graph/mst_kruskal_with_dsu.html
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 */
package spoj.partial.page1;

import java.util.*;
import java.io.*;

// Accepted --- https://www.spoj.com/status/MST,henrychen222/
class P3188 {
    static PrintWriter pw;

    /*
    4 5
    1 2 10
    2 4 15
    3 4 4
    3 1 6
    1 4 5
    answer: 19
     */
    void solve(int n, int[][] edges) {
        edges = Arrays.stream(edges).map(x -> new int[]{x[0] - 1, x[1] - 1, x[2]}).toArray(int[][]::new);
        pr(MSTKruskal(n, edges));
    }

    long MSTKruskal(int n, int[][] edges) { // edges: [u, v, weight]
        Arrays.sort(edges, Comparator.comparingInt(x -> x[2])); // sort increase based on weight
        DJSet ds = new DJSet(n);
        long res = 0;
        for (int[] edge : edges) {
            if (!ds.union(edge[0], edge[1])) res += edge[2];
        }
        return res;
    }

    static class DJSet {
        int[] p;
        int n;
        int[] rank;

        DJSet(int n) {
            this.p = new int[n];
            this.n = n;
            Arrays.fill(p, -1);
            this.rank = new int[n];
        }

        int find(int x) {
            return p[x] < 0 ? x : (p[x] = find(p[x]));
        }

        boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
//                if (rank[x] < rank[y]) {
//                    p[x] = y;
//                } else if (rank[x] > rank[y]) {
//                    p[y] = x;
//                } else {
//                    p[y] = x;
//                    rank[x]++;
//                }
                if (rank[x] < rank[y]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                p[y] = x;
                if (rank[x] == rank[y]) rank[x]++;
            }
            return x == y;
        }

        boolean equiv(int x, int y) {
            return find(x) == find(y);
        }

        int count() {
            int cnt = 0;
            for (int u : p) if (u < 0) cnt++;
            return cnt;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[][] edges = new int[m][];
        for (int i = 0; i < m; i++) edges[i] = fs.readArray(3);
        solve(n, edges);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignore) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new P3188().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignore) {
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