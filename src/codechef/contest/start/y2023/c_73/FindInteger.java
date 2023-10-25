/**
 * 01/11/23 morning
 * https://www.codechef.com/START73C/problems/SUMDIV2
 */
package codechef.contest.start.y2023.c_73;

import java.util.*;
import java.io.*;

// Accepted
class FindInteger {
    static PrintWriter pw;
    final long max = (long) 1e18;

    /*
     18 42 -> 66 192 318 444 570 696 822 948 ...       diff is all 126 (192-66  318-192)
     100 200 -> 100 300 500 700 900
     */
    //
    void solve(int X, int Y) {
        long x = X, y = Y;
        long lcm = lcm(x, y);
        // tr("lcm", lcm);
//        for (int n = 1; n <= 1000; n++) {
//            if ((n + x) % y == 0 && (n + y) % x == 0) {
//                tr(n);
//            }
//        }
        long start = -(x + y) + lcm;
        // tr(start);
        for (long v = start; ; v += lcm) {
            if (v > 0) {
                pr(v);
                return;
            }
        }
    }

    long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return a / gcd(a, b) * b;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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
        new FindInteger().run();
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
