/**
 * 03/22/23 noon
 * https://www.codechef.com/START82C/problems/FIND_X
 */
package codechef.contest.start.y2023.c_82;

import java.util.*;
import java.io.*;

class FindEX {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/92803937
    // reference: https://discuss.codechef.com/t/find-x-editorial/105590
    void solve(int a, int b, int c, int d) {
        if ((a + 1) % b == (c + 1) % d) {
            pr(1);
            return;
        }
        long res = lcm(b, d) - a % b;
        pr(res);
    }

    // TLE
    /*
    1
    123456789 123456788 113456788 133456788
     */
    void solve1(int a, int b, int c, int d) {
        // tr("test", test(a, b, c, d));
        if ((a + 1) % b == (c + 1) % d) {
            pr(1);
            return;
        }
        long lcm = lcm(b, d), res = -1;
        for (long mul = lcm / d, t = 0; t < 10; mul++, t++) {
            long v = mul * d;
            long x = v / d - c;
            // tr("mul", mul, "v", v, "d", d, "x", x);
            if (x > 0 && (a + x) % b == (c + x) % d) {
                res = x;
                break;
            }
        }
        for (long mul = lcm / b; ; mul++) {
            long v = mul * b;
            long x = v / b - a;
            // tr("mul", mul, "v", v, "b", b, "x", x);
            if (x > 0 && (a + x) % b == (c + x) % d) {
                res = Math.min(res, x);
                break;
            }
        }
        pr(res);
    }

    long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return a / gcd(a, b) * b;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    int test(int a, int b, int c, int d) {
        for (int x = 1; ; x++) {
            if ((a + x) % b == (c + x) % d) {
                tr("v", a + x);
                return x;
            }
        }
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
        new FindEX().run();
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
