/**
 * 03/11/22 morning
 * https://codeforces.com/contest/1647/problem/D
 */
package codeforce.cf.div2.r777;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1647/submission/149333372
    // reference cuiaoxiang
    void solve(int x, int d) {
        int cnt = 0;
        while (x % d == 0) {
            x /= d;
            cnt++;
        }
        boolean ok = false;
        if (cnt > 1) {
            int ways = ways(x, d);
            if (cnt >= 3) {
                ways += ways(x * d, d);
            }
            if (cnt >= 4) {
                ways += ways(d, d);
            }
            // tr("ways", ways);
            if (ways > 1) ok = true;
        }
        pr(ok ? "YES" : "NO");
    }

    int ways(int x, int d) {
        int res = 0;
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                if (i % d != 0 && (x / i % d != 0)) res++;
            }
        }
        return res;
    }

    boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }

    ///////////////////////////////////////////////////////////////////
    boolean isBeautiful(int x, int d) {
        if (!isGood(x, d)) return false;
        int[] factors = toArray(findAllGoodFactors(x, d));
        int n = factors.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (factors[i] * factors[j] == x) return false;
            }
        }
        return true;
    }

    int[] toArray(TreeSet<Integer> se) {
        int[] a = new int[se.size()];
        int p = 0;
        for (int x : se) a[p++] = x;
        return a;
    }

    boolean isGood(int x, int d) {
        return x % d == 0;
    }

    TreeSet<Integer> findAllGoodFactors(int n, int d) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    if (isGood(i, d)) res.add(i);
                } else {
                    if (isGood(i, d)) res.add(i);
                    if (isGood(n / i, d)) res.add(n / i);
                }
            }
        }
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int x = fs.nextInt(), d = fs.nextInt();
            solve(x, d);
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
        new D().run();
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