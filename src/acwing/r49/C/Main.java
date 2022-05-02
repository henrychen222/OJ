/**
 * 04/30/22 morning
 * https://www.acwing.com/problem/content/4418/
 */
package acwing.r49.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;
    private final int mod = 998244353;
    int cnt1, cnt2;
    int[] color;
    long[] ways;

    // Accepted --- 4531ms
    /*
      reference: https://www.acwing.com/solution/content/113905/
     */
    void solve(int n, int m, int[][] edges) {
        List<List<Integer>> g = initializeGraph(n + 1);
        packUG(g, edges);
        color = new int[n + 1];
        ways = new long[n + 1];
        ways[0] = 1;
        for (int i = 1; i <= n; i++) ways[i] = 2L * ways[i - 1] % mod;
        // tr(ways);
        long res = 1;
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                cnt1 = 0;
                cnt2 = 0;
                if (!dfs(g, i, 1)) {
                    res = 0;
                    break;
                }
                res = res * (ways[cnt1] + ways[cnt2]);
                res %= mod;
            }
        }
        pr(res);
    }

    boolean dfs(List<List<Integer>> g, int cur, int curColor) {
        color[cur] = curColor;
        if (curColor == 1) {
            cnt1++;
        } else {
            cnt2++;
        }
        for (int child : g.get(cur)) {
            if (color[child] == 0) {
                if (!dfs(g, child, 3 - curColor)) return false;
            } else if (color[child] == curColor) {
                return false;
            }
        }
        return true;
    }

    /////////////////////////////////////////////////////////
    /*
       /    \
     1 - 4 - 2
       \ |  /
         3
     */
    // WA
    void solve1(int n, int m, int[][] edges) {
        // tr(n, m, edges);
        List<List<Integer>> g = initializeGraph(n + 1);
        packUG(g, edges);
        // tr("g", g);
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        boolean[] visit = new boolean[n + 1];
        int[] depth = new int[n + 1];
        while (!q.isEmpty()) {
            int cur = q.poll();
            // tr("cur", cur);
            for (int child : g.get(cur)) {
                if (visit[child]) {
                    if (depth[child] % 2 == 1 - depth[cur] % 2) {
                        continue;
                    } else {
                        pr(0);
                        return;
                    }
                }
                depth[child] = depth[cur] + 1;
                q.add(child);
                visit[child] = true;
            }
        }
//        tr("visit", visit);
//        tr("depth", depth);
        long res1 = 0, res2 = 0, res = 0;
        for (int i = 1; i <= n; i++) {
            if (depth[i] == 0) continue;
            if (depth[i] % 2 == 0) {
                res1++;
                res1 %= mod;
            } else {
                res2++;
                res2 %= mod;
            }
            res = ((1L << res1) + (1L << res2)) % mod;
        }
        pr(res % mod);
    }

    void packUG(List<List<Integer>> g, int[][] edges) {
        for (int[] a : edges) {
            g.get(a[0]).add(a[1]);
            g.get(a[1]).add(a[0]);
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
            int n = fs.nextInt(), m = fs.nextInt();
            int[][] edges = new int[m][];
            for (int i = 0; i < m; i++) edges[i] = fs.readArray(2);
            solve(n, m, edges);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}