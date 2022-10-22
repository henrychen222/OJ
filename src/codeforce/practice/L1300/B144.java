/**
 * 10/18/22 night
 * https://codeforces.com/problemset/problem/144/B
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B144 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/144/176955859
    void solve(int n, int[] a, int[][] circles) {
        int xa = a[0], ya = a[1], xb = a[2], yb = a[3];
        int res = 0;
        for (int x = Math.min(xa, xb); x <= Math.max(xa, xb); x++) {
            for (int y = Math.min(ya, yb); y <= Math.max(ya, yb); y++) {
                if (x == xa || x == xb || y == ya || y == yb) { // sit in border
                    boolean ok = false;
                    for (int[] circle : circles) {
                        int cx = circle[0], cy = circle[1], r = circle[2];
                        if (inCircle(x, y, cx, cy, r)) {
                            ok = true;
                            break;
                        }
                    }
                    // tr(x, y, ok);
                    if (!ok) res++;
                }
            }
        }
        pr(res);
    }

    boolean inCircle(int x, int y, int cx, int cy, int r) {
        return Math.abs(x - cx) * Math.abs(x - cx) + Math.abs(y - cy) * Math.abs(y - cy) <= r * r;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(4);
        int n = fs.nextInt();
        int[][] circles = new int[n][];
        for (int i = 0; i < n; i++) circles[i] = fs.readArray(3);
        solve(n, a, circles);
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
        new B144().run();
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