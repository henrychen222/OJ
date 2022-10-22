/**
 * 08/27/22 morning
 * https://atcoder.jp/contests/abc266/tasks/abc266_b
 */
package atcoder.abc.r266.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;
    final long mod = 998244353;

    // Accepted --- https://atcoder.jp/contests/abc266/submissions/34408236
    // reference: jiangly
    void solve(long n) {
        n %= mod;
        if (n < 0) n += mod;
        pr(n);
    }

    /*
      n - x = mod * i
      x = n - mod * i
     */
    // WA
    void solve1(long n) {
        long close = n / mod * mod;
        n = Math.abs(n);
        close = Math.abs(close);
        // tr(n, close, close % mod);
        if (ok(n, n - close)) {
            pr(n - close);
            return;
        }
    }

    boolean ok(long n, long x) {
        return x > 0 && x < mod && (n - x) % mod == 0;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        long n = fs.nextLong();
        solve(n);
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
        new Main().run();
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