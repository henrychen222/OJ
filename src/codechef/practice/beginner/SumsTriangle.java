/**
 * 01/10/22 morning
 * https://www.codechef.com/problems/SUMTRIAN
 *
 * similar problem:
 * https://leetcode.com/problems/maximum-number-of-points-with-cost/discuss/1345021/javascript-easy-dp
 */
package codechef.practice.beginner;

import java.util.*;
import java.io.*;

class SumsTriangle {
    static PrintWriter pw;
    int[][] g;
    long res;
    int n;

    // Accepted --- https://www.codechef.com/viewsolution/56194183 debugged 5 times
    void solve() {
        res = 0;
        // int x = 0, y = 0;
        // dfs(x, y, g[x][y]);
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            int rowLen = g[i].length;
            for (int j = 0; j < rowLen; j++) {
                if (i == 0) {
                    dp[i][j] = g[i][j];
                } else {
                    long add;
                    if (j - 1 >= 0) { // col 1...rowLen - 1, previous row top, or left
                        add = g[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    } else { // col 0, only previous row top
                        add = g[i][j] + dp[i - 1][j];
                    }
                    dp[i][j] += add;
                }
            }
        }
        // tr(dp);
        for (int j = 0; j < n; j++) res = Math.max(res, dp[n - 1][j]);
        pr(res);
    }

//    void dfs(int x, int y, long sum) {
//        // tr(x + 1, y + 1, sum);
//        if (x == n - 1) {
//            res = Math.max(res, sum);
//            return;
//        }
//        int rowLen = g[x].length;
//        if (x + 1 < n) dfs(x + 1, y, sum + g[x + 1][y]);
//        if (x + 1 < n && y + 1 < rowLen) dfs(x + 1, y + 1, sum + g[x + 1][y + 1]);
//    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            g = new int[n][];
            for (int i = 0; i < n; i++) g[i] = fs.readArray(i + 1);
            solve();
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
        new SumsTriangle().run();
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

        char nextChar() {
            return next().charAt(0);
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}

