/**
 * 11/30/22 noon
 * https://www.codechef.com/START67B/problems/MUSROD
 */
package codechef.contest.start.b_67;

import java.util.*;
import java.io.*;

class MusicalRods {
    static PrintWriter pw;

    // Accepted
    // reference: https://discuss.codechef.com/t/musrod-editorial/104322
    void solve(int n, int[] a, int[] b) {
        int[][] d = new int[n][];
        for (int i = 0; i < n; i++) d[i] = new int[]{a[i], b[i]};
        Arrays.sort(d, (x, y) -> Double.compare((double) y[0] / y[1], (double) x[0] / x[1]));
        // tr(d);
        long res = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            res += d[i][1] * cur;
            cur += d[i][0];
            // tr("cur", cur, "res", res);
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n), b = fs.readArray(n);
            solve(n, a, b);
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
        new MusicalRods().run();
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
