/**
 * 02/18/22 evening
 * https://www.hackerrank.com/challenges/maxsubarray/problem
 */
package hackerrank.medium.s50;

import java.util.*;
import java.io.*;

public class TheMaxSubarray {
    static PrintWriter pw;

    // Accepted --- https://www.hackerrank.com/challenges/maxsubarray/submissions/code/257001528
    void solve(int n, int[] a) {
        // max subarray sum
        int[] dp = new int[n];
        dp[0] = a[0];
        int max = a[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + a[i];
            max = Math.max(max, dp[i]);
        }
        // max subsequence sum
        int sum = 0;
        for (int x : a) {
            if (x > 0) sum += x;
        }
        if (sum == 0) sum = Arrays.stream(a).max().getAsInt();
        pr(max + " " + sum);
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
        new TheMaxSubarray().run();
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
