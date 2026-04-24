/**
 * 04/10/26 morning
 * https://codeforces.com/problemset/problem/103/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B103 {
    static PrintWriter pw;

    // reference: https://codeforces.com/blog/entry/2426?locale=en
    // Accepted --- https://codeforces.com/problemset/submission/103/370601247
    void solve(int n, int[][] edges) {
        if (n != edges.length) {
            pr("NO");
            return;
        }
        DJSet ds = new DJSet(n + 1);
        for (int[] e : edges) ds.union(e[0], e[1]);
//        tr(ds.count(), ds.p, ds.grp());
        var groups = ds.grp();
        for (var group : groups) {
            if (group.size() == n) { // [1...n] all connected in one group
                pr("FHTAGN!");
                return;
            }
        }
        pr("NO");
    }

    class DJSet {
        int[] p;
        int n;

        DJSet(int n) {
            this.p = new int[n];
            this.n = n;
            Arrays.fill(p, -1);
        }

        int find(int x) {
            return p[x] < 0 ? x : (p[x] = find(p[x]));
        }

        boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return false;
            if (p[x] < p[y]) {
                int d = x;
                x = y;
                y = d;
            }
            p[x] += p[y];
            p[y] = x;
            return true;
        }

        boolean equiv(int x, int y) {
            return find(x) == find(y);
        }

        int count() {
            int cnt = 0;
            for (int u : p) if (u < 0) cnt++;
            return cnt;
        }

        List<List<Integer>> grp() {
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; i++) g.add(new ArrayList<>());
            for (int i = 0; i < n; i++) g.get(find(i)).add(i);
            return g;
        }
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[][] edges = new int[m][];
        for (int i = 0; i < m; i++) edges[i] = fs.readArray(2);
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
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new B103().run();
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
                } catch (IOException ignored) {
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