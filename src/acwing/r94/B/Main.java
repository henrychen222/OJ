/**
 * 03/11/23 morning
 * https://www.acwing.com/problem/content/4874/
 */
package acwing.r94.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;
    Map<String, Integer> costM;

    // Accepted --- https://www.acwing.com/problem/content/submission/code_detail/22832227/
    // reference: https://www.acwing.com/activity/content/competition/rank/2961/1/
    void solve(int n, int m, int[][] edges, Set[] forbid) {
        List<List<Integer>> g = initializeGraph(n + 1);
        costM = new HashMap<>();
        packUGCost(g, edges);
//        tr(g, costM);
        long[] dis = new long[n + 1];
        Arrays.fill(dis, Long.MAX_VALUE);
        Deque<long[]> q = new ArrayDeque<>();
//        PriorityQueue<long[]> q = new PriorityQueue<>((x, y) -> {
//            if (x[1] != y[1]) return Long.compare(x[1], y[1]);
//            return Long.compare(x[0], y[0]);
//        });
        q.add(new long[]{1L, 0L});
        dis[1] = 0L;
        while (!q.isEmpty()) {
            long[] tmp = q.poll();
            int cur = (int) tmp[0];
            long t = dis[cur];
            Set<Long> se = forbid[cur];
            while (se.contains(t)) {
                t++;
            }
            // tr("cur", tmp);
            for (int child : g.get(cur)) {
                int cost = costM.get(cur + " " + child);
                // tr("cost", cost, "forbidMove", forbidMove, "dis[cur]", dis[cur]);
                if (dis[child] > t + cost) {
                    dis[child] = t + cost;
                    q.add(new long[]{child, t + cost});
                }
            }
        }
        // tr(dis);
        pr(dis[n] == Long.MAX_VALUE ? -1 : dis[n]);
    }

    List<List<Integer>> initializeGraph(int n) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    void packUGCost(List<List<Integer>> g, int[][] edges) {
        for (int[] a : edges) {
            g.get(a[0]).add(a[1]);
            g.get(a[1]).add(a[0]);
            costM.put(a[0] + " " + a[1], a[2]);
            costM.put(a[1] + " " + a[0], a[2]);
        }
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[][] edges = new int[m][];
        for (int i = 0; i < m; i++) edges[i] = fs.readArray(3);
        Set[] forbid = new Set[n + 1];
        for (int i = 0; i < n; i++) {
            String[] a = fs.nextLine().split(" ");
            forbid[i + 1] = new HashSet();
//            for (String c : a) {
//                forbid[i + 1].add(Integer.parseInt(c));
//            }
            for (int j = 1; j < a.length; j++) {
                forbid[i + 1].add(Long.parseLong(a[j]));
            }
        }
        solve(n, m, edges, forbid);
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

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}