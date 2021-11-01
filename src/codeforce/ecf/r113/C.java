/**
 * 09/08/21 morning
 * https://codeforces.com/contest/1569/problem/C
 */
package codeforce.ecf.r113;

import java.util.*;
import java.io.*;

// TLE --- https://codeforces.com/contest/1569/submission/128285905 (array needs to shuffle before sorting)
// Accepted --- https://codeforces.com/contest/1569/submission/128398026
// reference: cuiaoxiang
public class C {

    static PrintWriter pw;

    private final int mod = 998244353;
    private final int N = (int) 2e5 + 10;
    int[] fact = new int[N]; // factorial
    int[] ifact = new int[N];
    int[] inv = new int[N];

    void comb_init() {
        inv[1] = 1;
        for (int i = 2; i < N; i++) inv[i] = (int) ((mod - mod / i) * (long) inv[mod % i] % mod);
        fact[0] = ifact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = (int) ((long) fact[i - 1] * i % mod);
            ifact[i] = (int) ((long) ifact[i - 1] * inv[i] % mod);
        }
    }

    void solve(int n, int[] a) {
        shuffleArray(a); // issue: needs to shuffle first otherwise TLE  https://codeforces.com/blog/entry/7108
        Arrays.sort(a);
        int max = a[n - 1], smax = a[n - 2];
        if (n > 1 && max > smax + 1) {
            pr(0);
            return;
        }
        if (n > 1 && max == smax) {
            pr(fact[n]);
            return;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == smax) cnt++;
        }
        int res = (int) (fact[n] * pow_mod(cnt + 1, mod - 2, mod) % mod);
        res = (fact[n] + mod - res) % mod;
        pr(res);
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

    void shuffleArray(int[] a) {
        int n = a.length;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            int randomPos = i + rnd.nextInt(n - i);
            a[i] = a[randomPos];
            a[randomPos] = tmp;
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    // don't know
    void solve1(int n, int[] a) {
        Arrays.sort(a);
        // tr(a);
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] >= 2) {
                pr(0);
                return;
            }
        }
        long tot = factorial(n, n) % mod;
        Map<Integer, Integer> m = counter(a);
        long same = 0;
        for (int k : m.keySet()) {
            int v = m.get(k);
            if (v > 1) {
                same += factorial(v, v);
                same %= mod;
            }
        }
        pr(tot - same);
    }

    long factorial(int m, int n) {
        long num = 1;
        int cnt = 0;
        for (int i = m; i > 0; i--) {
            if (cnt == n) break;
            num *= i;
            cnt++;
        }
        return num;
    }

    Map<Integer, Integer> counter(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        comb_init();
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new C().run();
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