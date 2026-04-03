/**
 * 12/14/24 morning
 * https://atcoder.jp/contests/abc384/tasks/abc384_d
 */
package atcoder.abc.r384.D;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // WA https://atcoder.jp/contests/abc384/submissions/60772453
    // AC https://atcoder.jp/contests/abc384/submissions/60778417
    boolean isSumPossible(int[] A, long S) {
        int N = A.length;
        long[] prefixSum = new long[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }
        // tr(prefixSum);
        long totalPeriodSum = prefixSum[N];
        Map<Long, Long> remainderMap = new HashMap<>();
        remainderMap.put(0L, 0L);
        for (int i = 1; i <= N * 2; i++) { // issue
            long modSum = ((prefixSum[i % N] % totalPeriodSum) + totalPeriodSum) % totalPeriodSum;
//        for (int i = 1; i <= N; i++) {
//            long modSum = ((prefixSum[i] % totalPeriodSum) + totalPeriodSum) % totalPeriodSum;
            long targetRemainder = minus_mod(modSum, S % totalPeriodSum, totalPeriodSum);
            // tr(modSum, targetRemainder, remainderMap);
            if (remainderMap.containsKey(targetRemainder)) {
                return true;
            }
            remainderMap.put(modSum, (long) i);
        }
        return false;
    }

    long minus_mod(long x, long y, long mod) { // use this
        return ((x - y) % mod + mod) % mod;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long s = fs.nextLong();
        int[] a = fs.readArray(n);
        pr(isSumPossible(a, s) ? "Yes" : "No");
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

        long nextLong() {
            return Long.parseLong(next());
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