/**
 * 01/18/23 morning
 * https://www.codechef.com/problems/CANDIES3
 */
package codechef.contest.start.y2023.c_74;

import java.util.*;
import java.io.*;

class Candies {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/86112198
    // reference: https://discuss.codechef.com/t/candies3-editorial/104926
    void solve(int n, int m, int[] a, int[] c) {
        int[] f = new int[m + 1];
        for (int x : a) f[x]++;
        long[] pre = preSum(f);
        pre = Arrays.copyOfRange(pre, 1, pre.length);
        // tr(pre);
        long res = Long.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            long v = 0;
            for (int j = i; j <= m; j += i) {
                int r = Math.min(m, i + j - 1);
                v += j / i * subArraySum(pre, j - 1, r - 1);
            }
            res = Math.max(res, v * c[i - 1]);
        }
        pr(res);
    }

    long[] preSum(int[] a) {
        int n = a.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + a[i];
        return pre;
    }

    long subArraySum(long[] a, int l, int r) {
        return a[r + 1] - a[l];
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            int[] a = fs.readArray(n);
            int[] c = fs.readArray(m);
            solve(n, m, a, c);
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
        new Candies().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
