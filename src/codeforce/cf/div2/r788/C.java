/**
 * 05/06/22 morning
 * https://codeforces.com/contest/1670/problem/C
 */
package codeforce.cf.div2.r788;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;
    final int mod = (int) 1e9 + 7;

    // Accepted --- https://codeforces.com/contest/1670/submission/156126109
    // reference: um_nik
    // union node is 1...n permutation
    void solve(int n, int[] a, int[] b, int[] c) {
        // tr(n, a, b, c);
        DJSet ds = new DJSet(n + 1);
        long res = 1;
        boolean[] used = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (c[i] != 0) used[c[i]] = true; // set non-zero to be used node
        }
        for (int i = 0; i < n; i++) {
            if (c[i] != 0) continue; // no-zero used
            int u = a[i], v = b[i];
            if (used[u] || used[v] || u == v) continue; // u == v duplicate
            if (!ds.union(u, v)) { // union failed, already connected (same group)
                res *= 2;
                res %= mod;
            }
        }
        pr(res);
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
            for (int u : parent) if (u < 0) cnt++;
            return cnt;
        }
    }

    ///////////////////////////////////////////////////////////
    // wrong has duplicates
    void solve1(int n, int[] a, int[] b, int[] c) {
        // tr(n, a, b, c);
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                if (b[i] == 0) {
                } else {
                    res++;
                }
            } else {
                if (b[i] == 0) {
                    res++;
                } else {
                    res += 2;
                }
            }
            res %= mod;
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n), b = fs.readArray(n), c = fs.readArray(n);
            solve(n, a, b, c);
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
        new C().run();
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