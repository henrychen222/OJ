/**
 * 02/23/22 night
 * https://www.codechef.com/problems/POUR1
 * https://www.spoj.com/problems/POUR1/
 */
package codechef.practice.medium;

import java.util.*;
import java.io.*;

class PouringWater {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/59038504
    // reference: https://massivealgorithms.blogspot.com/2016/04/spoj-25-pouring-waterpour1.html
    void solve(int a, int b, int c) {
        int g = gcd(a, b);
        if (c % g != 0 || c > a && c > b) {
            pr(-1);
        } else {
            int res = Math.min(check(a, b, c), check(b, a, c));
            pr(res);
        }
    }

    int check(int a, int b, int c) {
        int res = 0, ca = 0, cb = 0;
        while (true) {
            // tr(res, ca, cb);
            if (ca == c || cb == c) return res;
            if (cb == b) {
                cb = 0;
            } else if (ca == 0) {
                ca = a;
            } else {
                int dt = Math.min(b - cb, ca);
                ca -= dt;
                cb += dt;
            }
            res++;
        }
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // WA
    void solve1(int a, int b, int c) {
        int max = Math.max(a, b);
        if (max < c) {
            pr(-1);
        } else if (max > c) {
            pr(2);
        } else {
            pr(0);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int a = fs.nextInt(), b = fs.nextInt(), c = fs.nextInt();
            solve(a, b, c);
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
        new PouringWater().run();
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
