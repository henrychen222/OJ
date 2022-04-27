/**
 * 04/21/22 afternoon
 * https://codeforces.com/contest/1669/problem/H
 */
package codeforce.cf.div4.r784;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/contest/1669/submission/154441183
public class H {
    static PrintWriter pw;
    int n, k;
    private final int len = 31;

    /*
      1...  11
      1...  10
      1...  11
      1...  01
     */
    void solve(int[] a) {
//        tr(n, k, a);
        int[] f = new int[len];
        for (int x : a) {
            String s = Integer.toString(x, 2);
            if (s.length() < len) s = "0".repeat(len - s.length()) + s;
//            tr(x, s);
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '1') {
                    f[i]++;
                }
            }
        }
        // tr("f", f);
        int[][] d = new int[len][];
        for (int i = 0; i < len; i++) d[i] = new int[]{f[i], len - i - 1};
        // tr("d", d);
        fillFromHighest(d);
        long res = 0;
        for (int i = 0; i < len; i++) {
            if (d[i][0] == n) {
                res += 1L << d[i][1];
            }
        }
        pr(res);
    }

    void fillFromHighest(int[][] d) {
        Arrays.sort(d, (x, y) -> y[1] - x[1]);
        // tr("d1", d);
        for (int i = 0; i < len; i++) {
            int occ = d[i][0];
            if (occ >= n) continue;
            int need = n - occ;
            // tr("k", k, "need", need);
            if (k - need >= 0) {
                k -= need;
                d[i][0] = n;
            }
        }
        // tr("d2", d);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            k = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(a);
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
        new H().run();
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