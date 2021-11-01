/**
 * 09/18/21 morning
 * https://atcoder.jp/contests/abc219/tasks/abc219_d
 */
package atcoder.abc.r219.D;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    private final int MAX = Integer.MAX_VALUE - 1;

    // Accepted --- https://atcoder.jp/contests/abc219/submissions/25962031 167ms
    // reference: https://atcoder.jp/contests/abc219/submissions/25930738
    void solve(int n, int X, int Y, int[][] a) {
        int[][] dp = new int[X + 1][Y + 1];
        for (int i = 0; i <= X; i++) Arrays.fill(dp[i], MAX);
        dp[0][0] = 0;
        for (int[] e : a) {
            for (int i = X; i >= 0; i--) {
                for (int j = Y; j >= 0; j--) {
                    int ni = Math.min(X, i + e[0]), nj = Math.min(Y, j + e[1]);
                    // tr(ni, nj);
                    dp[ni][nj] = Math.min(dp[ni][nj], dp[i][j] + 1);
                }
            }
        }
        // tr(dp);
        int res = dp[X][Y] > n ? -1 : dp[X][Y];
        pr(res);
    }

    // WA
    void solve1(int n, int X, int Y, int[][] a) {
        // tr(n, X, Y, a);
        int sa = 0, sb = 0;
        for (int[] e : a) {
            sa += e[0];
            sb += e[1];
        }
        if (sa < X || sb < Y) {
            pr(-1);
            return;
        }
        Arrays.sort(a, (x, y) -> {
            if (X > Y) {
                return (2 * y[0] + y[1]) - (2 * x[0] + x[1]);
            } else {
                return (y[0] + 2 * y[1]) - (x[0] + 2 * x[1]);
            }
        });
        // tr(a);
        sa = 0;
        sb = 0;
        for (int i = 0; i < n; i++) {
            sa += a[i][0];
            sb += a[i][1];
            // tr(sa, sb);
            if (sa >= X && sb >= Y) {
                pr(i + 1);
                return;
            }
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int x = fs.nextInt();
        int y = fs.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = fs.nextInt();
            a[i][1] = fs.nextInt();
        }
        solve(n, x, y, a);
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