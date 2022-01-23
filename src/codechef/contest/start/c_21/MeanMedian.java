/**
 * 01/05/22 noon
 * https://www.codechef.com/START21C/problems/MEANIDIAN
 */
package codechef.contest.start.c_21;

import java.util.*;
import java.io.*;

class MeanMedian {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/55911974
    // reference: https://www.codechef.com/viewsolution/55851778
    // read:
    void solve(int n, int[] a) {
        long sum = 0;
        for (int x : a) sum += x;
        Arrays.sort(a);
        long low = a[(n - 1) / 2], high = (long) 1e9, res = -1;
        while (low <= high) {
            long mid = low + high >>> 1;
            // tr(mid, res);
            if (ok(mid, sum, n, a)) {
                res = mid * n - sum;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        pr(res);
    }

    boolean ok(long mid, long sum, int n, int[] a) {
        long need = 0;
        for (int i = (n - 1) / 2; i < n; i++) {
            need += Math.max(mid - a[i], 0);
        }
        return need <= mid * n - sum;
    }

    // don't know
    void solve1(int n, int[] a) {
        double median = n % 2 == 0 ? (double) (a[n / 2 - 1] + a[n / 2]) / 2 : a[n / 2];
        long sum = 0;
        for (int x : a) sum += x;
        tr(sum / n, median);
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
        new MeanMedian().run();
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