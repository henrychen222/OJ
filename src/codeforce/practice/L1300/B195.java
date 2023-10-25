/**
 * 01/11/23 night
 * https://codeforces.com/problemset/problem/195/B
 *
 * rewrite in java
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B195 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/195/188970623  560ms
    /*
     Original JS: https://codeforces.com/contest/195/submission/176085291 1778ms
     PHP:
     https://codeforces.com/problemset/submission/195/188935925 1152ms
     https://codeforces.com/problemset/submission/195/188951574 1560ms
     */
    void solve(int n, int m) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] != y[0]) return Double.compare(x[0], y[0]);
            if (x[1] != y[1]) return Double.compare(x[1], y[1]);
            return Double.compare(x[2], y[2]);
        });
        for (int i = 1; i <= m; i++) {
            double dis = Math.abs((double) (m + 1) / 2 - i);
            pq.add(new double[]{0, dis, i});
        }
        List<List<Integer>> g = initializeGraph(m + 1);
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            double[] cur = pq.poll();
            cur[0]++;
            g.get((int) cur[2]).add(i);
            pq.add(cur);
        }
        for (int i = 1; i <= m; i++) {
            for (int ball : g.get(i)) res[ball] = i;
        }
        for (int i = 1; i <= n; i++) pr(res[i]);
    }

    List<List<Integer>> initializeGraph(int n) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(2);
        solve(a[0], a[1]);
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
        new B195().run();
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
