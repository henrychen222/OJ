/**
 * 11/05/22 morning
 * https://atcoder.jp/contests/abc276/tasks/abc276_b
 */
package atcoder.abc.r276.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int m, int[][] edges) {
        List<List<Integer>> g = initializeGraph(n + 1);
        packUG(g, edges);
        for (int i = 1; i <= n; i++) {
            int len = g.get(i).size();
            if (len > 0) {
                pw.print(len + " ");
                Collections.sort(g.get(i));
                outputL(g.get(i));
            } else {
                pr(0);
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

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[][] edges = new int[m][];
        for (int i = 0; i < m; i++) edges[i] = fs.readArray(2);
        solve(n, m, edges);
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