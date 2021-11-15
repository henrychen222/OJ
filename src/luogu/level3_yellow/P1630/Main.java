/**
 * 11/11/21 evening
 * https://www.luogu.com.cn/problem/P1630
 */
package luogu.level3_yellow.P1630;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    private final int M = 10000;

    // Accepted --- https://www.luogu.com.cn/record/62310203
    // reference: https://www.programmerall.com/article/189566429/
    void solve(int a, int b) {
        long[] exp = new long[M + 1];
        long[] sum = new long[M + 1];
        for (int i = 0; i < M; i++) {
            exp[i] = pow_mod(i, b, M);
            if (i == 0) {
                sum[i] = exp[i];
            } else {
                sum[i] = sum[i - 1] + exp[i];
            }
        }
        pr(((sum[M - 1] * (a / M) % M) + sum[a % M]) % M);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        while (n-- > 0) {
            int a = fs.nextInt(), b = fs.nextInt();
            solve(a, b);
        }
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