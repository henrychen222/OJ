/**
 * 06/29/23 morning 08/31/23 evening completed
 * https://codeforces.com/contest/1845/problem/B
 */
package codeforce.ecf.y2023.r151;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1845/submission/221265153
    // reference: https://codeforces.com/blog/entry/117791
    void solve(int xa, int ya, int xb, int yb, int xc, int yc) {
        int AB = Math.abs(xa - xb) + Math.abs(ya - yb);
        int AC = Math.abs(xa - xc) + Math.abs(ya - yc);
        int BC = Math.abs(xb - xc) + Math.abs(yb - yc);
        pr((AB + AC - BC) / 2 + 1);
    }

    /////////////////////////////////////////////////////////////////
    // WA
    void solve1(int xa, int ya, int xb, int yb, int xc, int yc) {
        int x_moveAB = Math.abs(xa - xb), y_moveAB = Math.abs(ya - yb);
        int x_moveAC = Math.abs(xa - xc), y_moveAC = Math.abs(ya - yc);
        int minX = Math.min(xb, xc), maxX = Math.max(xb, xc);
        int x_move, y_move;
        if (xa < minX) {
            x_move = minX - xa;
            y_move = Math.min(y_moveAB, y_moveAC);
            // tr("A left", x_move, y_move);
        } else if (xa > maxX) {
            x_move = xa - maxX;
            y_move = Math.min(y_moveAB, y_moveAC);
            // tr("A right", x_move, y_move);
        } else {
            if (xa == xb && xb == xc) { // 在同列
                if (ya < Math.min(yb, yc)) {
                    pr(Math.min(yb, yc) - ya + 1);
                } else if (ya > Math.max(yb, yc)) {
                    pr(ya - Math.max(yb, yc) + 1);
                } else {
                    pr(1);
                }
                return;
            }
            x_move = 0;
            y_move = Math.min(y_moveAB, y_moveAC);
            // tr("A middle", x_move, y_move);
        }
        pr(y_move + x_move + 1);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2), b = fs.readArray(2), c = fs.readArray(2);
            solve(a[0], a[1], b[0], b[1], c[0], c[1]);
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
        new B().run();
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
