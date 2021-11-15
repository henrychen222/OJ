/**
 * 11/11/21 noon
 * https://leetcode-cn.com/problems/yqj8Su/
 */
package leetcodecn.meituan2021;

import java.util.*;
import java.io.*;

public class A5 {
    static PrintWriter pw;
    private final int mod = 998244353;

    // Accepted --- 112ms 88.10%
    // reference: https://leetcode-cn.com/problems/0VvYxa/solution/ji-yi-hua-dong-tai-gui-hua-by-laymedown-7qxo/
    // 题解 https://leetcode-cn.com/problems/0VvYxa/solution/java-dp-112ms-8810-by-coffeehenry-nyqg/
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), res = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) dp[1][i] = 1;
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = j; k <= n; k += j) {
                    dp[i][k] += dp[i - 1][j];
                    dp[i][k] %= mod;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            res += dp[m][i];
            res %= mod;
        }
        pr(res);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new A5().run();
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
