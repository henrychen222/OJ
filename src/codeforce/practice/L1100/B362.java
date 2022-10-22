/**
 * 05/04/22 afternoon
 * https://codeforces.com/problemset/problem/362/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B362 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/362/155877005
    void solve(int n, int m, int[] a) {
        if (m == 0) {
            pr("YES");
            return;
        }
        Arrays.sort(a);
        for (int i = 0; i < m; i++) {
            if (i + 2 < m) {
                if (a[i] + 1 == a[i + 1] && a[i + 1] + 1 == a[i + 2]) {
                    pr("NO");
                    return;
                }
            }
        }
//        if (1 + 3 < a[0] || a[m - 1] + 3 < n || a[m - 1] == n) {
//            pr("NO");
//            return;
//        }
        if (a[0] == 1 || a[m - 1] == n) {
            pr("NO");
            return;
        }
        pr("YES");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[] a = fs.readArray(m);
        solve(n, m, a);
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
        new B362().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}