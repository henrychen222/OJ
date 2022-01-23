/**
 * 11/20/21 morning
 * https://atcoder.jp/contests/abc228/tasks/abc228_c
 */
package atcoder.abc.r228.C;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    // don't know
    void solve(int n, int k, int[][] g) {
        tr(n, k, g);
        int[] low = new int[n];
        int[] high = new int[n];
        TreeMap<Integer, Integer> ml = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, Integer> ms = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int sum = g[i][0] + g[i][1] + g[i][2];
            ms.put(sum, ms.getOrDefault(sum, 0) + 1);
            ml.put(sum + 100, ml.getOrDefault(sum + 100, 0) + 1);
            low[i] = sum;
            high[i] = sum + 100;
        }
        tr(ms);
        tr(ml);
        for (int i = 0; i < n; i++) {
            TreeMap<Integer, Integer> t = ms;
            int x = low[i], xocc = t.get(x);
            if (xocc > 1) {
                t.put(x, xocc - 1);
            } else {
                t.remove(x);
            }
            int add = high[i];
            t.put(add, t.getOrDefault(add, 0) + 1);
            tr("tmp", t);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[][] g = new int[n][];
        for (int i = 0; i < n; i++) {
            int[] a = fs.readArray(3);
            g[i] = a;
        }
        solve(n, k, g);
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