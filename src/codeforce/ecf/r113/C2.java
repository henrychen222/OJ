// 09/09/21 night
// kmjp
package codeforce.ecf.r113;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/contest/1569/submission/128398471
// TLE --- https://codeforces.com/contest/1569/submission/128396651 (not shuffle before sort)
public class C2 {

    static PrintWriter pw;

    private final long mod = 998244353;

    long[] fact = new long[202020];

    void comb_init() {
        fact[0] = 1;
        for (int i = 1; i <= 200000; i++) fact[i] = fact[i - 1] * i % mod;
    }

    void solve(int n, int[] a) {
        // Arrays.sort(a);
        sort_inc(a);  // shuffle first to avoid TLE
        if (a[n - 1] > a[n - 2] + 1) {
            pr(0);
        } else if (a[n - 1] == a[n - 2]) {
            pr(fact[n]);
        } else {
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (a[i] == a[n - 2]) cnt++;
            }
            pr(fact[n] * (cnt - 1) % mod * pow_mod(cnt, mod - 2, mod) % mod);
        }
    }

    long pow_mod(long a, long b, long mod) {
        long r = 1;
        while (b > 0) {
            if (b % 2 == 1) r = r * a % mod;
            b >>= 1;
            a = a * a % mod;
        }
        return r;
    }

    void sort_inc(int[] a) {
        shuffleArray(a);
        Arrays.sort(a);
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
        new C2().run();
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