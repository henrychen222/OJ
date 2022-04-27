/**
 * 04/01/22 night
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1/0000000000a45ef7
 */
package codejam.y2022.Qualification.D;

import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter pw;

    // Accepted  04/26/22 evening
    // reference: neal_wu
    void solve(int n, int[] f, int[] p) {
        // tr(n, f, p);
        List<List<Integer>> g = initializeGraph(n + 1);
        for (int i = 0; i < n; i++) {
            p[i]--;
            if (p[i] >= 0) g.get(p[i]).add(i);
        }
        long res = 0;
        int[] up = new int[n];
        for (int node = n - 1; node >= 0; node--) { // [0, n - 1] node
            List<Integer> sorted = new ArrayList<>();
            for (int child : g.get(node)) sorted.add(up[child]);
            Collections.sort(sorted);
            while (sorted.size() > 1) {
                res += sorted.get(sorted.size() - 1);
                sorted.remove(sorted.size() - 1);
            }
            if (sorted.size() == 0) sorted.add(0);
            up[node] = Math.max(sorted.get(0), f[node]);
        }
        for (int node = 0; node < n; node++) {
            if (p[node] < 0) res += up[node];
        }
        pr(res);
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
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            int n = fs.nextInt();
            int[] f = fs.readArray(n), p = fs.readArray(n);
            solve(n, f, p);
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
        new Solution().run();
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