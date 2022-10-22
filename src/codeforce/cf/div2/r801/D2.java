/**
 * 06/18/22 morning
 * https://codeforces.com/contest/1695/problem/D2
 * https://codeforces.com/contest/1695/problem/D1
 */
package codeforce.cf.div2.r801;

import java.util.*;
import java.io.*;

public class D2 {
    static PrintWriter pw;

    /*
     Accepted
     https://codeforces.com/contest/1695/submission/161130128  (D2)
     https://codeforces.com/contest/1695/submission/161130259  (D1)
     reference: https://codeforces.com/blog/entry/103996
     */
    void solve(int n, int[][] edges) {
        List<List<Integer>> g = initializeGraph(n + 1);
        packUG(g, edges);
        int maxDeg = 0;
        for (var e : g) maxDeg = Math.max(maxDeg, e.size());
        if (maxDeg == 0) {
            pr(0);
        } else if (maxDeg < 3) {
            pr(1);
        } else {
            for (int i = 1; i <= n; i++) {
                if (g.get(i).size() >= 3) {
                    int res = dfs(g, i, i);
                    pr(res);
                    break;
                }
            }
        }
    }

    int dfs(List<List<Integer>> g, int cur, int parent) {
        int sum = 0, cnt = 0;
        for (int child : g.get(cur)) {
            if (child != parent) {
                int x = dfs(g, child, cur);
                sum += x;
                if (x == 0) cnt++;
            }
        }
        return sum + Math.max(0, cnt - 1);
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
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[][] edges = new int[n - 1][];
            for (int i = 0; i < n - 1; i++) edges[i] = fs.readArray(2);
            solve(n, edges);
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
        new D2().run();
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