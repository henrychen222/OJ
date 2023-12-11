/**
 * 12/07/23 noon
 * https://www.hackerrank.com/challenges/bfsshortreach
 */
package hackerrank.medium.s55;

import java.util.*;
import java.io.*;

public class BreadthFirstSearchShortestReach {
    static PrintWriter pw;

    // Accepted --- https://www.hackerrank.com/challenges/bfsshortreach/submissions/code/359574755
    void solve(int n, int[][] edges, int start) {
        List<List<Integer>> g = initializeGraph(n + 1);
        packUG(g, edges);
        int[] dis = minDisGraph(g, start);
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = dis[i] == Integer.MAX_VALUE ? -1 : dis[i] * 6;
        }
        // tr(res);
        int[] ans = new int[n - 1];
        int p = 0;
        for (int i = 1; i <= n; i++) {
            if (i != start) ans[p++] = res[i - 1];
        }
        outputA(ans);
    }

    int[] minDisGraph(List<List<Integer>> g, int start) {
        int n = g.size();
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int child : g.get(cur)) {
                if (dis[child] > dis[cur] + 1) {
                    dis[child] = dis[cur] + 1;
                    q.add(child);
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

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int q = fs.nextInt();
        for (int i = 0; i < q; i++) {
            int n = fs.nextInt(), m = fs.nextInt();
            int[][] edges = new int[m][];
            for (int j = 0; j < m; j++) edges[j] = fs.readArray(2);
            int start = fs.nextInt();
            solve(n, edges, start);
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
        new BreadthFirstSearchShortestReach().run();
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
