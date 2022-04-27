/**
 * 04/24/22 afternoon
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000087711b/0000000000accfdb
 */
package codejam.y2022.round1B.B;

import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter pw;

    // Accepted 04/26/22 afternoon completed
    // reference: neal_wu
    void solve(int n, int p, int[][] g) {
        // tr(n, p, g);
        Map<Integer, Long> dp = new HashMap<>();
        dp.put(0, 0L);
        for (int i = 0; i < n; i++) {
            Arrays.sort(g[i]);
            Map<Integer, Long> ndp = new HashMap<>();
            int first = g[i][0], last = g[i][p - 1];
            ndp.put(first, Long.MAX_VALUE);
            ndp.put(last, Long.MAX_VALUE);
            for (int press : dp.keySet()) {
                ndp.put(last, Math.min(ndp.get(last), dp.get(press) + Math.abs(press - first) + last - first));
                ndp.put(first, Math.min(ndp.get(first), dp.get(press) + Math.abs(press - last) + last - first));
            }
            dp = ndp;
        }
        long res = Long.MAX_VALUE;
        for (long v : dp.values()) res = Math.min(res, v);
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            int n = fs.nextInt(), p = fs.nextInt();
            int[][] g = new int[n][];
            for (int i = 0; i < n; i++) g[i] = fs.readArray(p);
            solve(n, p, g);
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