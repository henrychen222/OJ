/**
 * 05/06/22 afternoon
 * https://codeforces.com/contest/1670/problem/E
 */
package codeforce.cf.div2.r788;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/contest/1670/submission/156145403
// reference: Heltion(use) liouzhou_101 Um_nik
public class E {
    static PrintWriter pw;
    int[][] edges;
    List<List<Integer>> g;

    void solve(int n) {
        // tr(n, edges);
        g = initializeGraph(n + 1);
        for (int i = 1; i < n; i++) {
            g.get(edges[i][0]).add(i);
            g.get(edges[i][1]).add(i);
        }
        // tr(g);
        pr(1);
        int[] res = minimumCostSimplePath(n);
        outputA(res);
    }

    int cnt;

    int[] minimumCostSimplePath(int n) {
        int[] res = new int[2 * n];
        res[1] = n;
        cnt = 0;
        dfs(n, 1, 0, 0, res);
        return res;
    }

    void dfs(int n, int cur, int parent, int depth, int[] res) {
        // tr("cur", cur, "parent", parent, "depth", depth, "cnt", cnt, "res", res);
        for (int i : g.get(cur)) {
            int child = edges[i][0] ^ edges[i][1] ^ cur;
            // tr("child", child, edges[i][0], edges[i][1]);
            if (child != parent) {
                cnt++;
                if (depth == 1) {
                    res[n + i] = cnt;
                    res[child] = n + cnt;
                } else {
                    res[n + i] = n + cnt;
                    res[child] = cnt;
                }
                dfs(n, child, cur, depth ^ 1, res);
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

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int p = fs.nextInt(), n = 1 << p;
            edges = new int[n][2]; // make first [0, 0] save in [1...n]
            for (int i = 1; i < n; i++) {
                edges[i][0] = fs.nextInt();
                edges[i][1] = fs.nextInt();
            }
            solve(n);
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
        new E().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    void outputA(int[] a) {
        for (int i = 1; i < a.length; i++) pw.print(a[i] + " ");
        pr("");
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