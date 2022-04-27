/**
 * 04/21/22 afternoon
 * https://codeforces.com/contest/1669/problem/F
 */
package codeforce.cf.div4.r784;

import java.util.*;
import java.io.*;

public class F {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1669/submission/154444690
    void solve(int n, int[] a) {
//        tr(n, a);
        long[] pre = Arrays.copyOfRange(preSum(a), 1, n + 1), suf = sufSum(a);
//        tr(pre);
//        tr(suf);
        Map<Long, Integer> mp = value_idx(pre), ms = value_idx(suf);
//        tr(mp);
//        tr(ms);
        int res = 0;
        for (long x : mp.keySet()) {
            if (ms.containsKey(x)) {
                int i = mp.get(x), j = ms.get(x);
                if (i < j) res = Math.max(res, n - (j - i) + 1);
            }
        }
        pr(res);
    }

    Map<Long, Integer> value_idx(long[] a) {
        Map<Long, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) m.put(a[i], i);
        return m;
    }

    long[] preSum(int[] a) {
        int n = a.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + a[i];
        return pre;
    }

    long[] sufSum(int[] a) {
        int n = a.length;
        long[] suf = new long[n];
        suf[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) suf[i] = suf[i + 1] + a[i];
        return suf;
    }

    private void run() {
        read_write_file(); // comment this before submission
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
        new F().run();
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