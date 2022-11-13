/**
 * 10/22/22 morning
 * https://atcoder.jp/contests/abc274/tasks/abc274_c
 */
package atcoder.abc.r274.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    // reference: https://atcoder.jp/contests/abc274/submissions/35879008
    void solve(int n, int[] a) {
        int m = 2 * n + 1;
        int[] dep = new int[m + 5];
        for (int i = 1; i <= n; i++) {
            int v = a[i - 1];
            dep[2 * i] = dep[v] + 1;
            dep[2 * i + 1] = dep[v] + 1;
        }
        for(int i = 1; i <= m; i++) pr(dep[i]);
    }

    ////////////////////////////////////////////////
    /*
      1 -> 2 * 1   2 * 1 + 1   (2, 3)
      3 -> 2 * 2   2 * 2 + 1   (4, 5)
      5 -> 2 * 3   2 * 3 + 1   (6, 7)
      2 -> 2 * 4   2 * 4 + 1   (8, 9)
     */
    void solve1(int n, int[] a) {
        int m = 2 * n + 1;
        int[] pa = new int[m + 5];
        for (int i = 1; i <= n; i++) {
            int v = a[i - 1];
            pa[2 * i] = v;
            pa[2 * i + 1] = v;
        }
        // tr(pa);
        for (int i = 1; i <= m; i++) {
            int cur = i, gen = 1;
            if (i == 1) {
                pr(0);
                continue;
            }
            // tr("cur begin", cur);
            while (pa[cur / 2] > 0) {
                cur /= 2;
                gen++;
            }
            // tr("cur after", cur, "gen", gen);
            pr(cur);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
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