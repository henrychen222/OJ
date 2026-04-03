/**
 * 12/23/24 afternoon  12/24/24 morning complete
 * https://www.acwing.com/problem/content/201/
 */
package acwing.practice.medium.P199;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    void solve(int n, int k) {
        pr(sumOf_k_mod_n(n, k));
    }

    // Accepted
    long sumOf_k_mod_n(int n, int k) { // k % 1 + k % 2 + ... + k % n
        long sum = 0;
        int start = 1;
        while (start <= n) {
            int q = k / start;
            int end = q == 0 ? n : Math.min(k / q, n);
//            for (int j = start; j <= end; j++) {
//                sum += k % j;
//            }

            /*
             k % i = k − i * q (q = k / i)  i: [start, end]
             => 区间模和 = k * 区间长度 - 商quotient * 区间和
             */
            sum += (long) k * (end - start + 1) - q * sumOfRange(start, end);
            start = end + 1;
        }
        // tr(sum, test(n, k));
        return sum;
    }

    long sumOfRange(long l, long r) {
        return (l + r) * (r - l + 1) / 2;
    }

    int test(int n, int k) {
        int res = 0;
        for (int i = 1; i <= n; i++) res += k % i;
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        solve(n, k);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Main().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
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