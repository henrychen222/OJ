/**
 * 01/19/22 evening
 * https://www.codechef.com/COOK01/problems/BWKNIGHT
 */
package codechef.contest.cook.r01;

import java.util.*;
import java.io.*;

class TheBlackWhiteKnights {
    static PrintWriter pw;
    int n, m;

    /*
      [2, n - 1 - 2]    0  1    n - 1 - 1  n - 1
     */
    void solve() {
        long res = 0, tot = n * m, internal = (n - 1 - 2 - 2 + 1) * (m - 1 - 2 - 2 + 1);
        res += (tot - 1 - 8) * internal;
        // miss four edge
        int[] di = new int[]{0, 1, n - 1 - 1, n - 1};
        int[] dj = new int[]{0, 1, m - 1 - 1, m - 1};
        for (int i : di) {
            for (int j : dj) {
                int attack = 0;
                if (ok(i - 2, j - 1)) attack++;
                if (ok(i - 2, j + 1)) attack++;
                if (ok(i + 2, j - 1)) attack++;
                if (ok(i + 2, j + 1)) attack++;
                if (ok(i - 1, j - 2)) attack++;
                if (ok(i - 1, j + 2)) attack++;
                if (ok(i + 1, j - 2)) attack++;
                if (ok(i + 1, j + 2)) attack++;
                res += tot - 1 - attack;
            }
        }
        pr(res);
    }

    boolean ok(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            m = fs.nextInt();
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
        new TheBlackWhiteKnights().run();
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