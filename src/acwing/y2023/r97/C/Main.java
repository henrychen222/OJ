/**
 * 04/01/23 morning
 * https://www.acwing.com/problem/content/4949/
 */
package acwing.y2023.r97.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;
    boolean[] invalid;
    List<List<Integer>> g;
    int[] color;
    int M;

    // WA
    void solve(int n, int m, int[] a, int[][] edges) {
        g = initializeGraph(n + 1);
        color = a;
        M = m;
        packUG(g, edges);
        invalid = new boolean[n + 1];
        int[] black = new int[n + 1];
        dfs(1, -1, black);
        tr(invalid);
        int res = 0;
        for (boolean e : invalid) {
            if (e) res++;
        }
        pr(res + 1);
    }

    void dfs(int cur, int par, int[] black) {
        // if (invalid[cur]) return;
        // tr(cur, par);
        if (color[cur - 1] != 1) return;
        if (black[cur] >= M) {
            invalid[cur] = true;
            return;
        }
        for (int child : g.get(cur)) {
            if (child != par) {
                if (color[child - 1] == 1) {
                    black[child]++;
                    dfs(child, par, black);
                    black[child]--;
                }
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