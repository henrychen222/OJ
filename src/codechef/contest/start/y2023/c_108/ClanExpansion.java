/**
 * 11/16/23 afternoon
 * https://www.codechef.com/START108C/problems/CLANEXPNSN
 */
package codechef.contest.start.y2023.c_108;

import java.util.*;
import java.io.*;

class ClanExpansion {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/1030296848
    void solve(int n, int[] A) {
        TreeMap<Integer, TreeSet<Integer>> m = counter_value_in_indexA_in(A);
        int[][] res = new int[m.size()][];
        // tr(A, m);
        int p = 0;
        for (int x : m.keySet()) {
            TreeSet<Integer> ts = m.get(x);
            int max = 0;
            int[] a = TreeSetToArray(ts);
            // tr(x, a);
            if (!ts.contains(0)) {
                int firstD = ts.first();
                // tr("firstD", firstD);
                max = Math.max(max, firstD);
            }
            if (!ts.contains(n - 1)) {
                int lastD = n - 1 - ts.last();
                // tr("lastD", lastD);
                max = Math.max(max, lastD);
            }
            for (int i = 1; i < a.length; i++) {
                int d = a[i] - a[i - 1] - 1;
                d = (d + 1) / 2;
                // tr("d", d);
                max = Math.max(max, d);
            }
            res[p++] = new int[]{x, max};
        }
        // tr(res);
        Arrays.sort(res, (x, y) -> {
            if (x[1] != y[1]) return x[1] - y[1];
            return x[0] - y[0];
        });
        // tr(res);
        pr(res[0][0] + " " + res[0][1]);
    }

    TreeMap<Integer, TreeSet<Integer>> counter_value_in_indexA_in(int[] a) {
        TreeMap<Integer, TreeSet<Integer>> m = new TreeMap<>();
        for (int i = 0; i < a.length; i++) m.computeIfAbsent(a[i], x -> new TreeSet<>()).add(i);
        return m;
    }

    int[] TreeSetToArray(TreeSet<Integer> ts) {
        int[] a = new int[ts.size()];
        int p = 0;
        for (int x : ts) a[p++] = x;
        return a;
    }


    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new ClanExpansion().run();
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
