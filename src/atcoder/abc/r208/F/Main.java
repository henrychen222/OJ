/**
 * 07/05/21 morning  09/08/21 afternoon still not fixed
 * https://atcoder.jp/contests/abc208/tasks/abc208_f
 */

package atcoder.abc.r208.F;

import java.util.*;
import java.io.*;

// WA, don't know
class Main {

    static PrintWriter pw;

    private final int N = 3000000;
    private final int mod = (int) (1e9 + 7);
    int[] ifact = new int[N];
    int[] inv = new int[N];
    int[] fact = new int[N];

    void comb_init() {
        inv[1] = 1;
        for (int i = 2; i < N; i++) inv[i] = (int) ((mod - mod / i) * (long) inv[mod % i] % mod);
        fact[0] = ifact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = (int) ((long) fact[i - 1] * i % mod);
            ifact[i] = (int) ((long) ifact[i - 1] * inv[i] % mod);
        }
    }

    long large_range(long[] a, long n) {
        int m = a.length;
        if (n < m) return a[(int) n];
        long res = 0;
        for (int i = 0; i < m; i++) {
            if ((n - i) % mod == 0) {
                res = (long) ifact[i] * ifact[m - 1 - i] % mod * a[i] % mod;
                if ((m - 1 - i) % 2 != 0) res = mod - res;
                break;
            }
            long cur = (long) ifact[i] * ifact[m - 1 - i] % mod * pow_mod(n - i, mod - 2, mod) % mod * a[i] % mod;
            if ((m - 1 - i) % 2 != 0) cur = mod - cur;
            res += cur;
        }
        res %= mod;
        for (int i = 0; i < m; i++) {
            if ((n - i) % mod == 0) continue;
            res = (n - i) % mod * res % mod;
        }
        return res;
    }

    void solve(long n, long m, long k) {
        long[] a = new long[(int) (k + m + 1)];
        for (int i = 0; i < a.length; i++) a[i] = pow_mod(i, k, mod);
        for (int j = 0; j < m; j++) {
            long[] na = new long[a.length];
            na[0] = a[0];
            for (int i = 1; i < a.length; i++) {
                na[i] = (na[i - 1] + a[i]) % mod;
            }
            a = na;
        }
        pr(large_range(a, n));
    }

    long pow_mod(long a, long b, int mod) {
        long r = 1;
        while (b > 0) {
            if (b % 2 == 1) r = r * a % mod;
            b >>= 1;
            a = a * a % mod;
        }
        return r;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        comb_init();
        long n = fs.nextLong();
        long m = fs.nextLong();
        long k = fs.nextLong();
        solve(n, m, k);
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

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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