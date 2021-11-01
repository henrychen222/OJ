/**
 * 09/11/21 morning
 * https://atcoder.jp/contests/abc218/tasks/abc218_c
 */

package atcoder.abc.r218.C;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/abc218/submissions/25788076
    // reference: cuiaoxiang https://atcoder.jp/contests/abc218/submissions/25755038
    void solve(char[][] s, char[][] t) {
        s = canonical(s);
        for (int i = 0; i < 4; i++) {
            if (isSame(s, canonical(t))) {
                pr("Yes");
                return;
            }
            t = clockwise_rotate(t);
        }
        pr("No");
    }

    char[][] canonical(char[][] g) {
        int n = g.length;
        int xmin = Integer.MAX_VALUE, ymin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '#') {
                    xmin = Math.min(xmin, i);
                    ymin = Math.min(ymin, j);
                }
            }
        }
        char[][] res = new char[n][n];
        for (char[] e : res) Arrays.fill(e, '.');
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '#') {
                    res[i - xmin][j - ymin] = '#';
                }
            }
        }
        return res;
    }

    ///////////////////////////////////////////////////////////////////////////////
    void solve1(char[][] s, char[][] t) {
        tr("target", t);
        tr("begin", s);

        counter_clock_rotate(s);
        tr("ccr", s);
        if (isSame(s, t)) {
            pr("Yes");
            return;
        }

        char[][] res1 = clockwise_rotate(s);
        tr("res1", res1);
        if (isSame(res1, t)) {
            pr("Yes");
            return;
        }

        pr("NO");
    }

    // https://www.geeksforgeeks.org/rotate-matrix-90-degree-without-using-extra-space-set-2/
    void counter_clock_rotate(char[][] g) {
        int n = g.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char tmp = g[j][i];
                g[j][i] = g[i][j];
                g[i][j] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                char tmp = g[j][i];
                g[j][i] = g[k][i];
                g[k][i] = tmp;
            }
        }
    }

    // https://stackoverflow.com/questions/2799755/rotate-array-clockwise
    char[][] clockwise_rotate(char[][] g) {
        int n = g.length;
        char[][] res = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = g[i][j];
            }
        }
        return res;
    }

    boolean isSame(char[][] g, char[][] t) {
        int n = g.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != t[i][j]) return false;
            }
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        char[][] s = new char[n][n];
        char[][] t = new char[n][n];
        for (int i = 0; i < n; i++) s[i] = fs.next().toCharArray();
        for (int i = 0; i < n; i++) t[i] = fs.next().toCharArray();
        solve(s, t);
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