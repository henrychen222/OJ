/**
 * 08/28/22 evening
 * https://codeforces.com/problemset/problem/27/B
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B27 {
    static PrintWriter pw;
    Map<Integer, Integer> win;

    // Accepted --- https://codeforces.com/problemset/submission/27/170017105
    void solve(int n, int[][] edges) {
        List<Set<Integer>> g = initializeGraphSet(n + 1);
        packUG(g, edges);
        // tr(win, g);
        for (int i = 1; i <= n; i++) {
            Set<Integer> child = g.get(i);
            if (child.size() != n - 1) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (!child.contains(j)) {
                        int first, second;
                        if (win.getOrDefault(i, 0) > win.getOrDefault(j, 0)) {
                            first = i;
                            second = j;
                        } else {
                            first = j;
                            second = i;
                        }
                        pr(first + " " + second); // order matters
                        break;
                    }
                }
                break;
            }
        }
    }

    List<Set<Integer>> initializeGraphSet(int n) {
        List<Set<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new HashSet<>());
        }
        return g;
    }

    void packUG(List<Set<Integer>> g, int[][] edges) {
        for (int[] a : edges) {
            g.get(a[0]).add(a[1]);
            g.get(a[1]).add(a[0]);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = n * (n - 1) / 2 - 1;
        int[][] edges = new int[m][];
        win = new HashMap<>();
        for (int i = 0; i < m; i++) {
            edges[i] = fs.readArray(2);
            win.put(edges[i][0], win.getOrDefault(edges[i][0], 0) + 1);
        }
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
        new B27().run();
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