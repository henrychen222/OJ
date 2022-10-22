/**
 * 06/18/22 morning
 * https://atcoder.jp/contests/abc256/tasks/abc256_c
 */
package atcoder.abc.r256.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    /*
      a b c
      d e f
      g h m

      a + b + c = h1     a + d + g = w1

      d + e + f = h2     b + e + h = w2

      g + h + m = h3     c + f + m = w3
     */
    void solve(int h1, int h2, int h3, int w1, int w2, int w3) {
        // tr(ok(2, 1, 2, 2, 5, 6, 2, 7, 1, 5, 13, 10, 6, 13, 9));
        long res = 0;
        for (int a = 1; a <= Math.min(h1, w1); a++) {
            for (int b = 1; b <= Math.min(h1, w2); b++) {
                for (int d = 1; d <= Math.min(h2, w1); d++) {
                    for (int e = 1; e <= Math.min(h2, w2); e++) {
                        int c = h1 - a - b, f = h2 - d - e, g = w1 - a - d, h = w2 - b - e, m = w3 - c - f;
                        if (c > 0 && f > 0 && g > 0 && h > 0 && m > 0) {
                            // int[][] grid = {{a, b, c}, {d, e, f}, {g, h, m}};
                            if (ok(a, b, c, d, e, f, g, h, m, h1, h2, h3, w1, w2, w3)) {
//                                tr(grid);
                                res++;
                            }
                        }
                    }
                }
            }
        }
        pr(res);
    }

    boolean ok(int a, int b, int c, int d, int e, int f, int g, int h, int m, int h1, int h2, int h3, int w1, int w2, int w3) {
        return a + b + c == h1 && a + d + g == w1 && d + e + f == h2 && b + e + h == w2 && g + h + m == h3 && c + f + m == w3;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(6);
        solve(a[0], a[1], a[2], a[3], a[4], a[5]);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}