/**
 * 05/05/22 morning
 * https://codeforces.com/contest/1675/problem/D
 */
package codeforce.cf.div3.r787;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;

    /*
         3 < --- 4 <--- 1 ---> 2
     */
    // Accepted --- https://codeforces.com/contest/1675/submission/156018137
    // reference: kmjp
    void solve(int n, int[] p) {
        List<List<Integer>> g = initializeGraph(n + 1);
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (i + 1 != p[i]) {
                g.get(p[i]).add(i + 1);
            } else {
                root = i + 1;
            }
        }
//        tr(g, "n", n);
//        List<Integer> d = MinimumVerticesReachALLNodesDG(n + 1, g);
//        tr("vertices", d);

        List<List<Integer>> paths = MinimumNumberOfPathDG(n + 1, 1, root, g);
        // tr(paths);
        pr(paths.stream().filter(e -> e.size() != 0).count());
        for (List<Integer> path : paths) {
            if (path.size() != 0) {
                pr(path.size());
                outputL(path);
            }
        }
        pr("");
    }

    List<List<Integer>> MinimumNumberOfPathDG(int n, int start, int root, List<List<Integer>> g) {
        List<List<Integer>> paths = initializeGraph(n);
        Deque<Integer> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> path = new ArrayList<>();
            while (true) {
                path.add(cur);
                if (g.get(cur).size() == 0) break;
                // tr("cur", g.get(cur), g);
                for (int i = start; i < g.get(cur).size(); i++) {
//                    tr(g.get(cur).get(i));
                    q.add(g.get(cur).get(i));
                }
                cur = g.get(cur).get(0);
            }
            paths.add(path);
        }
        return paths;
    }

    List<Integer> MinimumVerticesReachALLNodesDG(int n, List<List<Integer>> g) {
        int[] degree = new int[n];
        List<Integer> d = new ArrayList<>();
        for (List<Integer> e : g) {
            for (int node : e) degree[node]++;
        }
        tr("deg", degree);
        for (var i = 1; i < n; i++) if (degree[i] == 0) d.add(i);
        return d;
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
            int n = fs.nextInt();
            int[] p = fs.readArray(n);
            solve(n, p);
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
        new D().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}