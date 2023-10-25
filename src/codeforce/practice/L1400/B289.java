/**
 * 02/24/23 morning
 * https://codeforces.com/problemset/problem/289/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B289 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/289/194803545
    void solve(int n, int m, int d, int[][] g) {
        int tot = n * m, p = 0;
        int[] a = new int[tot];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) a[p++] = g[i][j];
        }
        Arrays.sort(a);
        List<Integer> vs = new ArrayList<>();
        if (tot % 2 == 0) { // min moves comes from middle (greedy)
            vs.add(a[tot / 2 - 1]);
            vs.add(a[tot / 2]);
        } else {
            vs.add(a[tot / 2]);
        }
//        tr(a, vs);
        long res = Long.MAX_VALUE;
        for (int v : vs) {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//            int v = g[i][j];
            long move = 0;
            boolean ok = true;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    long diff = Math.abs(v - g[x][y]);
                    if (diff % d != 0) ok = false;
                    move += diff / d;
                }
            }
            // tr("v", v, "move", move);
            if (ok) res = Math.min(res, move);
//            }
//        }
        }
        pr(res == Long.MAX_VALUE ? -1 : res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), d = fs.nextInt();
        int[][] g = new int[n][];
        for (int i = 0; i < n; i++) g[i] = fs.readArray(m);
        solve(n, m, d, g);
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
        new B289().run();
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