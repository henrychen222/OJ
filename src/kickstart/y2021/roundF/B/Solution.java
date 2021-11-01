/**
 * 09/18/21 afternoon
 * https://codingcompetitions.withgoogle.com/kickstart/round/0000000000435bae/0000000000887dba
 */
package kickstart.y2021.roundF.B;

import java.util.*;
import java.io.*;

public class Solution {

    static PrintWriter pw;

    // Task 1 Pass, Task 2 TLE
    void solve(int d, int n, int k, int[][] a) {
        // tr(d, n, k);
        Arrays.sort(a, (x, y) -> y[0] - x[0]);
        // tr(a);
        long res = 0;
        for (int day = 1; day <= d; day++) {
            long sum = 0, cnt = 0;
            for (int[] e : a) {
                if (cnt == k) break;
                int hap = e[0], start = e[1], end = e[2];
                if (day >= start && day <= end) {
                    // tr("select", e);
                    sum += hap;
                    cnt++;
                }
            }
            // tr("day", day, sum);
            res = Math.max(res, sum);
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            int d = fs.nextInt();
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[][] a = new int[n][3];
            for (int i = 0; i < n; i++) {
                a[i][0] = fs.nextInt();
                a[i][1] = fs.nextInt();
                a[i][2] = fs.nextInt();
            }
            solve(d, n, k, a);
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