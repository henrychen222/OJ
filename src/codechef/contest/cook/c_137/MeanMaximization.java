/**
 * 01/23/21 morning
 * https://www.codechef.com/COOK137C/problems/MEANMAX
 */
package codechef.contest.cook.c_137;

import java.util.*;
import java.io.*;

class MeanMaximization {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] a) {
        long tot = 0;
        int max = 0;
        for (int x : a) {
            tot += x;
            max = Math.max(max, x);
        }
        int ln = 1, rn = n - 1;
        double lm = (double) max / ln, rm = (double) (tot - max) / rn;
        double totM = lm + rm;
        pr(totM);
    }

    // WA
    void solve1(int n, int[] a) {
        long tot = 0;
        for (int x : a) tot += x;
        long l = 0, r = tot;
        double res = 0;
        for (int i = 0; i + 1 < n; i++) {
            l += a[i];
            r -= a[i];
            int ln = i + 1, rn = n - i - 1;
            double lm = (double) l / ln, rm = (double) r / rn;
            double totM = lm + rm;
            // tr(l, ln, lm, "right", r, rn, rm, "totM", totM);
            res = Math.max(res, totM);
        }
        pr(res);
//        double b= 4.0;
//        tr(Math.abs(res - b) / Math.max(1, Math.abs(b)) <= Math.pow(10, -6));
        test(n, a, tot);
    }

    void test(int n, int[] a, long tot) {
        double res = 0;
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> sub = new ArrayList<>();
            long l = 0;
            int ln = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sub.add(a[j]);
                    l += a[j];
                    ln++;
                }
            }
            long r = tot - l;
            int rn = n - ln;
            if (ln > 0 && rn > 0) {
                double lm = (double) l / ln, rm = (double) r / rn;
                double totM = lm + rm;
                tr("lsum", sub, l, ln, "rsum", r, rn, "totM", totM);
                res = Math.max(res, totM);
            }
        }
        tr("test result", res);
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
        new MeanMaximization().run();
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

