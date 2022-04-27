/**
 * 03/08/22 morning
 * https://codeforces.com/contest/1650/problem/C
 */
package codeforce.cf.div3.r776;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1650/submission/148914465
    // reference:
    void solve(int n, int m, int[][] p) {
//        Arrays.sort(p, (x, y) -> x[0] - y[0]);
//        tr(n, m, p);
//        int[] w = new int[m];
//        for (int i = 0; i < m; i++) w[i] = p[i][1];
//        long[] pre = preSum(w);
//        tr(pre);
//        for (int i = 0; i < n; i++) {
//            int r = i + (n - i) * 2;
//            if (r < m) {
//                tr(i, r);
//            }
//        }
        int[][] d = new int[m][];
        for (int i = 0; i < m; i++) d[i] = new int[]{p[i][0], p[i][1], i + 1};
        Arrays.sort(d, (x, y) -> x[1] - y[1]);
        tr(d);
        long sum = 0;
        int[][] need = Arrays.copyOfRange(d, 0, 2 * n);
        for (int i = 0; i < 2 * n; i++) sum += need[i][1];
        Arrays.sort(need, (x, y) -> x[0] - y[0]);
         tr("need", need);
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) res[i] = new int[]{need[i][2], need[2 * n - i - 1][2]};
        // tr(res);
        pr(sum);
        outputInterval(res);
    }

    void outputInterval(int[][] a) {
        for (int[] e : a) pr(e[0] + " " + e[1]);
        pr("");
    }

    long[] preSum(int[] a) {
        int n = a.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + a[i];
        return pre;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            int[][] p = new int[m][];
            for (int i = 0; i < m; i++) p[i] = fs.readArray(2);
            solve(n, m, p);
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




