/**
 * 11/07/21 morning
 * https://atcoder.jp/contests/abc226/tasks/abc226_c
 */
package atcoder.abc.r226.C;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    // WA  AC 11 cases https://atcoder.jp/contests/abc226/submissions/27116547
    long res;
    void solve(int n, int[] t, int[][] a) {
        // tr(t, a);
        int[] f = a[n - 1];
        res = t[n - 1];
        for (int x : f) {
            dfs(x, t, a, new HashSet<>());
        }
        pr(res);
    }

    void dfs(int cur, int[] t, int[][] a, Set<Integer> vis) {
        int idx = cur - 1;
        if (a[idx].length == 0) {
            res += t[idx];
            vis.add(cur);
            return;
        }
        for (int child : a[idx]) {
            if (vis.contains(child)) continue;
            dfs(child, t, a, vis);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] a = new int[n][];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = fs.nextInt();
            int k = fs.nextInt();
            a[i] = fs.readArray(k);
        }
        solve(n, t, a);
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