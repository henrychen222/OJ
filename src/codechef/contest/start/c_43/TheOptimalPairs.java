/**
 * 06/15/22 morning  06/26/22 afternoon complete
 * https://www.codechef.com/START43C/problems/OPTPAIRS
 */
package codechef.contest.start.c_43;

import java.util.*;
import java.io.*;

class TheOptimalPairs {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/67692727
    // reference: https://discuss.codechef.com/t/optpairs-editorial/101602
    void solve(int n) {
        // test(n);
        long res = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i != 0) continue;
            int d = n / i;
            res += d == 2 ? 1 : 2;
            if (d != i && d != n) {
                res += n / d == 2 ? 1 : 2;
            }
        }
        pr(res);
    }

    // TLE https://www.codechef.com/viewsolution/66953198
    void test(int n) {
        long res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                long g = gcd(i, j) + lcm(i, j);
                if (g == n && i + j == n) {
                    tr(i, j, g);
                    res++;
                }
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

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new TheOptimalPairs().run();
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
