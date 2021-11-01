/**
 * 09/18/21 afternoon
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435bae/0000000000888d45
 */
package kickstart.y2021.roundF.C;

import java.util.*;
import java.io.*;

public class Solution {

    static PrintWriter pw;

    // Accepted  09/20/21 evening
    // reference: tmwilliamlin168
    void solve(int n, long[][] a, int[] b) {
        // tr(n, a, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] -= b[j];
            }
        }
        double res = 1e9;
        double[][] d = new double[n][n];
        for (double[] e : d) Arrays.fill(e, 1e9);
        for (int i = 0; i < n; i++) d[i][i] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { // two point
                // tr("i", i, "j", j);
                long x1 = a[i][0], y1 = a[i][1], x2 = a[j][0], y2 = a[j][1];
                if (x1 * y2 - x2 * y1 > 0) {
                    d[i][j] = Math.hypot(x1 - x2, y1 - y2);
                    // tr("d[i][j]", d[i][j]);
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j && ((k ^ i) != 0)) {
                        res = Math.min(d[i][k] + d[k][j], res);
//                        tr("res", res);
//                        tr(i, j, k, k ^ i);
                    }
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        if (res >= 1e9) {
            pr("IMPOSSIBLE");
            return;
        }
        pr(String.format("%.6f", res));
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            int n = fs.nextInt();
            long[][] a = new long[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = fs.nextLong();
                a[i][1] = fs.nextLong();
            }
            int[] b = new int[2];
            b[0] = fs.nextInt();
            b[1] = fs.nextInt();
            solve(n, a, b);
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
        new Solution().run();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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