/**
 * 04/01/23 morning
 * https://www.acwing.com/problem/content/4949/
 */
package acwing.y2023.r97.C;

import java.util.*;
import java.io.*;

// Accepted
// reference: https://www.acwing.com/activity/content/code/content/6117840/
class Main2 {
    static PrintWriter pw;
    List<List<Integer>> g;
    int[] color;
    int M, res;

    void solve(int n, int m, int[] a, int[][] edges) {
        g = initializeGraph(n + 1);
        color = a;
        M = m;
        packUG(g, edges);
        res = 0;
        dfs(1, -1, a[0]);
        pr(res);
    }

    void dfs(int cur, int par, int blackSum) {
        // tr(cur, par, blackSum);
        if (blackSum > M) return;
        if (g.get(cur).size() == 1 && cur != 1) res++;
        for (int child : g.get(cur)) {
            if (child != par) {
                dfs(child, cur, color[child - 1] == 0 ? 0 : blackSum + 1);
            }
        }
    }

    List<List<Integer>> initializeGraph(int n) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    void packUG(List<List<Integer>> g, int[][] edges) {
        for (int[] a : edges) {
            g.get(a[0]).add(a[1]);
            g.get(a[1]).add(a[0]);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[] a = fs.readArray(n);
        int[][] edges = new int[n - 1][];
        for (int i = 0; i < n - 1; i++) edges[i] = fs.readArray(2);
        solve(n, m, a, edges);
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
        new Main2().run();
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