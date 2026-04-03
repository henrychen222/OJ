/**
 * 05/19/23 noon
 * https://codeforces.com/contest/1833/problem/E
 */
package codeforce.cf.div3.y2023.r874;

import java.util.*;
import java.io.*;

public class E {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1833/submission/206550038
    // reference:
    void solve(int n, int[] a) {
        DJSet ds = new DJSet(n + 1);
        for (int i = 0; i < n; i++) ds.union(i + 1, a[i]);
        // tr(ds.parent);
        int max = ds.count(); // think correct in contest
        boolean[] chain = new boolean[n + 1];
        boolean hasChain = false;
        for (int i = 1; i <= n; i++) {
            if (a[a[i - 1] - 1] == i) {
                chain[ds.find(i)] = true;
                hasChain = true;
            }
        }
        int min = 0;
        // tr(chain);
        for (int i = 1; i <= n; i++) {
            int p = ds.find(i);
            if (p == i && !chain[p]) {
                min++;
            }
        }
        min += hasChain ? 1 : 0;
        pr(min + " " + max);
    }

    class DJSet {
        int[] parent;

        DJSet(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
        }

        int find(int x) {
            return parent[x] < 0 ? x : (parent[x] = find(parent[x]));
        }

        boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return false;
            if (parent[x] < parent[y]) {
                int d = x;
                x = y;
                y = d;
            }
            parent[x] += parent[y];
            parent[y] = x;
            return true;
        }

        boolean equiv(int x, int y) {
            return find(x) == find(y);
        }

        int count() {
            int cnt = 0;
            // for (int x : parent) if (x < 0) cnt++; // [0..n]
            for (int i = 1; i < parent.length; i++) if (parent[i] < 0) cnt++; // [1..n]
            return cnt;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new E().run();
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