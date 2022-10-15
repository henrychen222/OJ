/**
 * 10/14/22 night
 * https://codeforces.com/problemset/problem/230/B
 */
import java.util.*;
import java.io.*;

public class B230 {
    static PrintWriter pw;

    // Accepted
    void solve(int n, long[] a) {
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        for (long x: a) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        Set<Long> memo = new HashSet<>();
        for (long x: a) {
            if (isPerfectSqure(x)) {
                if (memo.contains(x)) {
                    pr("YES");
                    continue;
                } else {
                    if (isPrime((int) Math.sqrt(x), 4)) {
                        pr("YES");
                        memo.add(x);
                        continue;
                    }
                }
            }
            pr("NO");
        }
    }

    boolean isPerfectSqure (long n) {
       double sq = Math.sqrt(n);
       return isInteger(sq);
    }

    boolean isInteger (double n) {
       return n == (int) n;
    }

    boolean millerRabin (long d, int n) {
        long a = 2 + (long) Math.random() % (n - 4);
        long x = powmod(a, d, n);
        if (x == 1 || x == n - 1) return true;
        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;
            if (x == 1) return false;
            if (x == n - 1) return true;
        }
        return false;
    }

    long powmod (long a, long b, int mod) {
        long r = 1;
        while (b > 0) {
            if (b % 2 == 1) r = r * a % mod;
            b >>= 1;
            a = a * a % mod;
        }
        return r;
    }

    boolean isPrime (int n, int k) {
       if (n <= 1 || n == 4) return false;
       if (n <= 3) return true;
       int d = n - 1;
       while (d % 2 == 0) d /= 2;
       for (int i = 0; i < k; i++) {
           if (!millerRabin(d, n)) return false;
       }
       return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long[] a = fs.readArray(n);
        solve(n, a);
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
        new B230().run();
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
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