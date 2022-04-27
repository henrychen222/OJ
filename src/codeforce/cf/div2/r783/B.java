/**
 * 04/19/22 morning
 * https://codeforces.com/contest/1668/problem/B
 */
package codeforce.cf.div2.r783;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // WA
    // Accepted --- https://codeforces.com/contest/1668/submission/154144415
    void solve(int n, int m, int[] a) {
        // tr(n, m, a);
        if (n > m) {
            pr("NO");
            return;
        }
        Arrays.sort(a);  // fuck, greedy, should sort
        long cur = 0;
        // tr("cur", cur);
        for (int i = 1; i < n; i++) {
            int dis = 1 + Math.max(a[i - 1], a[i]);
            cur = cur + dis;
            // tr("cur", cur);
        }
        if (cur > m - 1) {
            pr("NO");
            return;
        }
        long lastDis = m - 1 - cur;
        // tr("lastDis", lastDis);
        pr(lastDis >= Math.max(a[0], a[n - 1]) ? "YES" : "NO");
    }

    /*
     (first version also works by adding sort)
     WA --- https://codeforces.com/contest/1668/submission/154108199
     Accepted --- https://codeforces.com/contest/1668/submission/154144547
     */
    void solve1(int n, int m, int[] a) {
        Arrays.sort(a);
        long cur = Math.max(a[0], a[n - 1]);
        for (int i = 1; i < n; i++) {
            cur = cur + Math.max(a[i - 1], a[i]) + 1;
        }
        pr(cur < m ? "YES" : "NO");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, m, a);
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
        new B().run();
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