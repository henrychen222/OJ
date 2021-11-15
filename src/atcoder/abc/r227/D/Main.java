/**
 * 11/13/21 morning
 * https://atcoder.jp/contests/abc227/tasks/abc227_d
 */
package atcoder.abc.r227.D;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    /**
     * reference:
     * https://atcoder.jp/contests/abc227/submissions/27213078 (kmjp use)
     * https://atcoder.jp/contests/abc227/submissions/27235865 (cuiaoxiang read)
     */
    // Accepted --- https://atcoder.jp/contests/abc227/submissions/27239401
    void solve(int n, int k, long[] a) {
        long res = 0;
        for (int i = 60; i >= 0; i--) {
            long ct = 1L << i;
            if (cnt(res + ct, n, k, a) >= res + ct) res += ct;
        }
        pr(res);
    }

    long cnt(long x, int n, int k, long[] a) {
        long sum = 0;
        for (int i = 0; i < n; i++) sum += Math.min(a[i], x);
        return sum / k;
    }

    // WA
    void solve1(int n, int k, long[] a) {
        //  tr(n, k, a);
        PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> Long.compare(y[1], x[1]));
        for (int i = 0; i < n; i++) pq.add(new long[]{i, a[i]});
        // tr("pq start", pq.toArray());
        long res = 0;
        while (pq.size() >= k) {
            int cnt = 0;
            while (!pq.isEmpty()) {
                if (cnt == k) break;
                long[] cur = pq.poll();
                // tr(cur);
                cur[1]--;
                if (cur[1] > 0) pq.add(cur);
                cnt++;
            }
            res++;
            // tr("pq", pq.toArray());
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        long[] a = fs.readArray(n);
        solve(n, k, a);
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
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