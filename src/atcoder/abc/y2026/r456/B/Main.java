/**
 * 05/02/26 morning
 * https://atcoder.jp/contests/abc456/tasks/abc456_b
 */
package atcoder.abc.y2026.r456.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(int[] a, int[] b, int[] c) {
        long[][] cnt = new long[3][7]; // cnt[die][value]
        for (int v : a) cnt[0][v]++;
        for (int v : b) cnt[1][v]++;
        for (int v : c) cnt[2][v]++;

        long favorable = 0;
        int[][] perms = {
                {4, 5, 6}, {4, 6, 5}, {5, 4, 6}, {5, 6, 4}, {6, 4, 5}, {6, 5, 4}
        };
        for (int[] p : perms) {
            favorable += cnt[0][p[0]] * cnt[1][p[1]] * cnt[2][p[2]];
        }

        long total = 216L; // 6^3
        double probability = (double) favorable / total;
        pr(probability);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        solve(fs.readArray(6), fs.readArray(6), fs.readArray(6));
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
        } catch (Exception ignored) {
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