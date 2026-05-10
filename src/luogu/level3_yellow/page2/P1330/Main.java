/**
 * 05/07/26 evening
 * https://www.luogu.com.cn/problem/P1330
 */
package luogu.level3_yellow.page2.P1330;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/277063243
    void solve(int n, int[][] edges) {
        var g = initializeGraph(n + 1);
        packUG(g, edges);
        long res = isBipartite(g, 1);
        pr(res == -1 ? "Impossible" : res);
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[][] edges = new int[m][];
        for (int i = 0; i < m; i++) edges[i] = fs.readArray(2);
        solve(n, edges);
    }

    /*
     reference:
     https://leetcode.com/problems/is-graph-bipartite/
     https://zxi.mytechroad.com/blog/graph/leetcode-886-possible-bipartition/
     https://www.geeksforgeeks.org/dsa/bipartite-graph/
     */
    Long isBipartite(List<List<Integer>> g, int start) {
        int n = g.size();
        Deque<Integer> q = new ArrayDeque<>();
        int[] color = new int[n];
        int uncolor = 0, red = 1, blue = -1;
        long res = 0;
        for (int i = start; i < n; i++) {
            if (color[i] == uncolor) {
                q.add(i);
                color[i] = red;
                int cntRed = 1, cntBlue = 0;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int child : g.get(cur)) {
                        if (color[child] == color[cur]) {
                            return -1L; // not Bipartite
                        } else if (color[child] == uncolor) {
                            color[child] = -color[cur];
                            q.add(child);
                            if (color[child] == red) {
                                cntRed++;
                            } else {
                                cntBlue++;
                            }
                        }
                    }
                }
                res += Math.min(cntRed, cntBlue);
            }
        }
        return res;
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

    <T> void pr(T t) {
        pw.println(t);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignore) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Main().run();
        pw.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignore) {
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