/**
 * 06/04/22 night
 * https://www.spoj.com/problems/EQBOX/
 */
package spoj.classical.page1;

import java.util.*;
import java.io.*;

class P35_EquipmentBox {
    static PrintWriter pw;

    // Accepted --- https://www.spoj.com/status/EQBOX,henrychen222/
    /*
      reference: https://github.com/viraj071/SPOJ/blob/master/35.%20Equipment%20Box/EQBOX.cpp
      http://discuss.spoj.com/t/eqbox-wa/1518/11
     */
    void solve(int a, int b, int x, int y) {
        pr(check(Math.max(a, b), Math.min(a, b), Math.max(x, y), Math.min(x, y)) ? "Escape is possible." : "Box cannot be dropped.");
    }

    boolean check(long a, long b, long x, long y) {
        if (x < a && y < b) return true;
        if (x >= a && y >= b) return false;
        double beta = Math.atan2(y, x);
        double alpha = Math.asin(b / Math.sqrt(x * x + y * y)) - beta;
        if (alpha < 0) return false;
        double p = y * Math.sin(alpha), q = Math.sqrt(x * x + y * y - b * b);
        if (2 * p + q - a >= 0) return false;
        else return true;
    }

    // [0, a] [0, b]
    // WA
    void solve1(int a, int b, int x, int y) {
        int endX = 1 + x, endY = 1 + y;
        if (endX < a && endY < b) {
            pr("Escape is possible.");
            return;
        }
        endX = 1 + y;
        endY = 1 + x;
        if (endX < a && endY < b) {
            pr("Escape is possible.");
            return;
        }
        pr("Box cannot be dropped.");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(4);
            solve(a[0], a[1], a[2], a[3]);
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
        new P35_EquipmentBox().run();
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
