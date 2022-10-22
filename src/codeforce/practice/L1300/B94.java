/**
 * 09/07/22 night
 * https://codeforces.com/problemset/problem/94/B
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B94 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/94/171290460
    void solve(int n, int[][] edges) {
        List<Set<Integer>> g = initializeGraphSet(6);
        packUGSet(g, edges);
        // tr(g);
        for (int i = 1; i <= 5; i++) {
            for (int j = i + 1; j <= 5; j++) {
                for (int k = j + 1; k <= 5; k++) {
                    boolean ij = know(g, i, j), ik = know(g, i, k), jk = know(g, j, k);
                    // tr(i, j, k);
                    if (ij && ik && jk){
                        // tr("three pairwise acquainted");
                        pr("WIN");
                        return;
                    }
                    if (!ij && !ik && !jk) {
                        // tr("three pairwise unacquainted");
                        pr("WIN");
                        return;
                    }
                }
            }
        }
        pr("FAIL");
    }

    boolean know(List<Set<Integer>> g, int x, int y) {
        return g.get(x).contains(y) || g.get(y).contains(x);
    }

    List<Set<Integer>> initializeGraphSet(int n) {
        List<Set<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new HashSet<>());
        }
        return g;
    }

    void packUGSet(List<Set<Integer>> g, int[][] edges) {
        for (int[] a : edges) {
            g.get(a[0]).add(a[1]);
            g.get(a[1]).add(a[0]);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] edges = new int[n][];
        for (int i = 0; i < n; i++) edges[i] = fs.readArray(2);
        solve(n, edges);
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
        new B94().run();
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