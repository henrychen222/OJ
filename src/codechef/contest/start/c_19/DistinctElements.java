/**
 * 12/11/21 morning
 * https://www.codechef.com/START19C/problems/DISTELE
 */
package codechef.contest.start.c_19;

import java.util.*;
import java.io.*;

class DistinctElements {
    static PrintWriter pw;
    private final int mod = (int) (1e9 + 7);

    // reference: https://www.geeksforgeeks.org/count-distinct-subsequences/
    // TLE WA https://www.codechef.com/viewsolution/54903691
    void solve(int n, int[] a) {
        int[] last = new int[1000005];
        Arrays.fill(last, -1);
        long[] dp = new long[n + 1];
        dp[0] = 1L;
        for (int i = 1; i <= n; i++) {
            dp[i] = 2L * dp[i - 1];
            if (last[a[i - 1]] != -1) dp[i] = dp[i] - dp[last[a[i - 1]]];
            dp[i] %= mod;
            last[a[i - 1]] = (i - 1);
        }
        pr((dp[n] % mod) - 1);
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
        new DistinctElements().run();
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