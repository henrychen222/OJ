/**
 * 08/27/22 morning
 * https://atcoder.jp/contests/abc266/tasks/abc266_c
 */
package atcoder.abc.r266.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(int[][] p) {
        pr(isPolygonConvex(p) ? "Yes" : "No");
    }

    // reference: https://www.geeksforgeeks.org/check-if-given-polygon-is-a-convex-polygon-or-not/
    boolean isPolygonConvex(int[][] points) {
        int n = points.length;
        int pre = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            int tmp[][] = {points[i], points[(i + 1) % n], points[(i + 2) % n]};
            cur = CrossProduct(tmp);
            if (cur != 0) {
                if (cur * pre < 0) {
                    return false;
                } else {
                    pre = cur;
                }
            }
        }
        return true;
    }

    static int CrossProduct(int A[][]) {
        int X1 = (A[1][0] - A[0][0]);
        int Y1 = (A[1][1] - A[0][1]);
        int X2 = (A[2][0] - A[0][0]);
        int Y2 = (A[2][1] - A[0][1]);
        return (X1 * Y2 - Y1 * X2);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[][] p = new int[4][];
        for (int i = 0; i < 4; i++) p[i] = fs.readArray(2);
        solve(p);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}