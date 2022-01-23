/**
 * 12/11/21 morning
 * https://atcoder.jp/contests/abc231/tasks/abc231_d
 */
package atcoder.abc.r231.D;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // WA
    void solve(int n, int m, int[][] edges) {
        // tr(n, m, edges);
        Map<Integer, Set<Integer>> g = new HashMap<>();
        packUGMap(g, edges);
        // tr(g);
        for (Set<Integer> se : g.values()) {
            if (se.size() > 2) {
                pr("No");
                return;
            }
        }
        pr("Yes");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[][] edges = new int[m][];
        for (int i = 0; i < m; i++) edges[i] = fs.readArray(2);
        solve(n, m, edges);
    }

    void packUGMap(Map<Integer, Set<Integer>> g, int[][] edges) {
        for (int[] a : edges) {
            if (!g.containsKey(a[0])) g.put(a[0], new HashSet<>());
            if (!g.containsKey(a[1])) g.put(a[1], new HashSet<>());
            g.get(a[0]).add(a[1]);
            g.get(a[1]).add(a[0]);
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