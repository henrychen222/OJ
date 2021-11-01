/**
 * 09/15/21 morning   09/17/21 afternoon complete
 * https://www.codechef.com/START11B/problems/COUNTA
 */
package codechef.contest.start.b_11;

import java.util.*;
import java.io.*;

class Counting {

    static PrintWriter pw;

    private final int mod = (int) 1e9 + 7;
    private final long max = (long) 1e5;

    /*
      [x 3 9 8 4]  [min(x, 3), 3, 8, 4]           (NO)
      [3 x 9 8 4]  [min(x, 3), min(x, 9), 8, 4]
      [3 9 x 8 4]  [3, min(x, 9), min(x, 8), 4]
      [3 9 8 x 4]  [3, 8, min(x, 8), min(x, 4)]   (NO)
      [3 9 8 4,x]  [3, 8, min(x, 8), min(x, 4)]   (NO)
     */
    // Accepted --- https://www.codechef.com/viewsolution/51230701
    // reference: https://discuss.codechef.com/t/counta-editorial/94488 (Tester's)
    void solve(int n, int[] b) {
        // tr(n, b);
        long[][] dp = new long[n][2];
        // tr(dp);
        dp[0][0] = 1L;
        dp[0][1] = max - b[0];
        for (int i = 1; i < n; i++) {
            if (b[i] >= b[i - 1]) dp[i][0] += dp[i - 1][0];
            if (b[i] == b[i - 1]) dp[i][0] += dp[i - 1][1];
            if (b[i] < b[i - 1]) dp[i][1] += dp[i - 1][1];
            dp[i][1] += Math.min(max - b[i - 1] + 1, max - b[i]) * dp[i - 1][0];
            dp[i][0] %= mod;
            dp[i][1] %= mod;
        }
        // tr(dp);
        long res = dp[n - 1][1] + dp[n - 1][0] * (max - b[n - 1] + 1);
        pr(res % mod);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            n--;
            int[] b = fs.readArray(n);
            solve(n, b);
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
        new Counting().run();
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