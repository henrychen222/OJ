/**
 * 06/22/22 morning
 * https://www.codechef.com/START44C/problems/JOGGING
 */
package codechef.contest.start.c_44;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Jogging {
    static PrintWriter pw;
    final int mod = (int) (1e9 + 7);
    final BigInteger bmod = new BigInteger(mod + "");
    Map<String, BigInteger> m;
    long[] power;

    // Accepted --- https://www.codechef.com/viewsolution/67401224
    // reference: https://www.youtube.com/watch?v=fzvCjzp3Vr4
    void solve(int n, int x) {
        long res = power[n - 1] * x % mod;
        pr(res);
    }

    /*
     TLE
     https://www.codechef.com/viewsolution/67359436
     https://www.codechef.com/viewsolution/67374310
     https://www.codechef.com/viewsolution/67377760
     */
    //
    void solve1(int n, int x) {
//        long[] dp = new long[n];
//        long sum = x;
//        for (int k = 0; k < n; k++) {
//            dp[k] = sum;
//            dp[k] %= mod;
//            sum += dp[k];
//            sum %= mod;
//        }
//        // tr(dp[n - 1], dp);
        String ke = n + " " + x;
        if (m.containsKey(ke)) {
            pr(m.get(ke));
            return;
        }
        BigInteger X = new BigInteger(x + ""), two = new BigInteger(2 + "");
        BigInteger res = X.multiply(two.pow(n - 1));
        res = res.mod(bmod);
        // long res = new BigInteger(x+"") * (1L << (n - 1));
        m.put(ke, res);
        pr(res);
    }

    void prepare() {
        m = new HashMap<>();
        power = new long[1000005];
        power[0] = 1;
        for (int i = 1; i < 1000005; i++) power[i] = power[i - 1] * 2 % mod;
    }

    private void run() {
        read_write_file(); // comment this before submission
        prepare();
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
        new Jogging().run();
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
