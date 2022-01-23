/**
 * 12/19/21 morning
 * https://www.codechef.com/COOK136C/problems/MEDMIN
 */
package codechef.contest.cook.c_136;

import java.util.*;
import java.io.*;

class MedianMinimization {

    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/55195611
    // reference: https://www.codechef.com/rankings/COOK136B
    void solve1(int n, int[] a) {
        Arrays.sort(a);
        pr(a[n / 2] - a[n / 2 - 1]);
    }

    // WA
    void solve(int n, int[] a) {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int[] l = Arrays.copyOfRange(a, 0, i);
            int[] r = Arrays.copyOfRange(a, i, n);
            int lm = median(l), rm = median(r);
            tr(l, r, lm, rm);
            res = Math.min(res, Math.abs(lm - rm));
        }
        pr(res);
    }

    int median(int[] a) {
        int n = a.length, i = (n + 1) / 2;
        int[] b = Arrays.copyOf(a, n);
        Arrays.sort(b);
        return b[i - 1];
    }

//    int median1(int[] a) {
//        Arrays.sort(a);
//        int n = a.length, i = (n + 1) / 2;
//        return a[i - 1];
//    }

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
        new MedianMinimization().run();
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