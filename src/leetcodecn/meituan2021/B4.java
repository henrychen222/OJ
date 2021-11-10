/**
 * 11/08/21 evening
 * https://leetcode-cn.com/problems/vSYUMc/
 */
package leetcodecn.meituan2021;

import java.util.*;
import java.io.*;

public class B4 {
    static PrintWriter pw;

    /*
         1 --- 2 --- 4
         |
         3 --- 5
     */
    // Accepted --- 168ms 95.30%
    // 题解 --- https://leetcode-cn.com/problems/vSYUMc/solution/java-graph-bfs-168ms-9530-by-coffeehenry-mp8w/
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), x = fs.nextInt(), y = fs.nextInt();
        List<List<Integer>> g = initializeGraph(n + 1);
        int[][] edges = new int[n - 1][];
        for (int i = 0; i < n - 1; i++) edges[i] = fs.readArray(2);
        packUG(g, edges);
        // tr(g);
        int[] disX = bfs(g, n, x);
        int[] disY = bfs(g, n, y);
//        tr(disX);
//        tr(disY);
        int res = 0;
        for (int i = 1; i <= n; i++) { // 选择小团先到小美后到的最大时间
            if (disX[i] > disY[i]) {
                res = Math.max(res, disX[i]);
            }
        }
        pr(res);
    }

    // https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
    int[] bfs(List<List<Integer>> g, int n, int start) { // bfs to all points (min step)
        boolean[] visit = new boolean[n + 1];
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        dis[start] = 0;
        while (q.size() > 0) {
            int cur = q.poll();
            // tr("cur", cur, "dis", dis);
            for (int next : g.get(cur)) {
                if (!visit[next]) {
                    if (dis[next] > dis[cur] + 1) {
                        dis[next] = dis[cur] + 1;
                        visit[next] = true;
                        q.add(next);
                    }
                }
            }
        }
        return dis;
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new B4().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
