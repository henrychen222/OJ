/**
 * 02/23/23 afternoon
 * https://www.codechef.com/START78C/problems/SOLVEMORE
 */
package codechef.contest.start.y2023.c_78;

import java.util.*;
import java.io.*;

class SolveMoreProblems {
    static PrintWriter pw;

    void solve(int n, int k, int[] a, int[] b) {
        long[][] d = new long[n][];
        for (int i = 0; i < n; i++) d[i] = new long[]{a[i] + b[i], b[i]};
        Arrays.sort(d, (x, y) -> {
            if (x[0] != y[0]) return Long.compare(x[0], y[0]);
            return Long.compare(x[1], y[1]);
        });
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + d[i][0];
        int res = 0;
        for (int i = 0; i < n; i++) {
            long t = k - d[i][1];
            if (t < 0) {

            } else if (t < pre[i - 1]) {

            } else {

            }
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
            int[] a = fs.readArray(n), b = fs.readArray(n);
            solve(n, k, a, b);
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
        new SolveMoreProblems().run();
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
