/**
 * 12/14/24 morning
 * https://codeforces.com/problemset/problem/120/D
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class D120 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/120/296469197
    void solve(int n, int m, int[][] g, int[] sons) {
        Arrays.sort(sons);
        prefixSum2D pf = new prefixSum2D(g);
        int res = 0;

//         horizontal cut
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                long A = pf.regionSum(0, 0, i, m - 1);
                long B = pf.regionSum(i + 1, 0, j, m - 1);
                long C = pf.regionSum(j + 1, 0, n - 1, m - 1);
                int[] cur = new int[]{(int) A, (int) B, (int) C};
                Arrays.sort(cur);
                if (Arrays.equals(cur, sons)) res++;
            }
        }
//        tr("horizontal", res);

        // vertical cut
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                long A = pf.regionSum(0, 0, n - 1, i);
                long B = pf.regionSum(0, i + 1, n - 1, j);
                long C = pf.regionSum(0, j + 1, n - 1, m - 1);
//                tr(A, B, C);
                int[] cur = new int[]{(int) A, (int) B, (int) C};
                Arrays.sort(cur);
                if (Arrays.equals(cur, sons)) res++;
            }
        }
        pr(res);
    }

    class prefixSum2D {
        int n, m;
        long[][] pre;

        prefixSum2D(int[][] g) {
            this.n = g.length;
            this.m = g[0].length;
            this.pre = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    long up = i - 1 >= 0 ? pre[i - 1][j] : 0;
                    long left = j - 1 >= 0 ? pre[i][j - 1] : 0;
                    long upLeft = (i - 1 >= 0 && j - 1 >= 0) ? pre[i - 1][j - 1] : 0;
                    pre[i][j] = g[i][j] + up + left - upLeft;
                }
            }
//            tr(pre);
        }

        long regionSum(int x1, int y1, int x2, int y2) { // top left: [x1, y1]  bottom right [x2, y2]
            long total = pre[x2][y2];
            long up = x1 - 1 >= 0 ? pre[x1 - 1][y2] : 0;
            long left = y1 - 1 >= 0 ? pre[x2][y1 - 1] : 0;
            long upLeft = (x1 - 1 >= 0 && y1 - 1 >= 0) ? pre[x1 - 1][y1 - 1] : 0;
            return total - up - left + upLeft;
        }
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[][] g = new int[n][];
        for (int i = 0; i < n; i++) g[i] = fs.readArray(m);
        int[] sons = fs.readArray(3);
        solve(n, m, g, sons);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
            pw = new PrintWriter(System.out); // print result into output.txt
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        // pw = new PrintWriter(System.out);
        new D120().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
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
