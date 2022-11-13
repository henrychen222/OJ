/**
 * 11/02/22 morning
 * https://www.codechef.com/START63C/problems/DELXORONE
 */
package codechef.contest.start.c_63;

import java.util.*;
import java.io.*;

class OneXORDeletions {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] a) {
        Map<Integer, Integer> m = counter(a);
        int[] b = {0, 1};
        int maxKeep = 0;
        for (int x : m.keySet()) {
            int keep = m.get(x);
            // tr("x", x);
            for (int y : b) {
                int canKeep = x ^ y;
                // tr("canKeep", canKeep);
                if (canKeep != x && m.containsKey(canKeep)) {
                    keep += m.get(canKeep);
                }
            }
            // tr("keep", keep);
            maxKeep = Math.max(maxKeep, keep);
        }
        pr(n - maxKeep);
    }

    Map<Integer, Integer> counter(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new OneXORDeletions().run();
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
