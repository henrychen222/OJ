/**
 * 04/24/22 morning
 * https://atcoder.jp/contests/arc139/tasks/arc139_b
 */
package atcoder.arc.r139.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;
    long n, a, b, x, y, z;

    // Accepted --- https://atcoder.jp/contests/arc139/submissions/31248752
    // reference: https://atcoder.jp/contests/arc139/submissions/31239078 uwi
    void solve() {
        y = Math.min(y, x * a);
        z = Math.min(z, z * b);
        long res = Math.min(y * (n / a) + x * (n - n / a * a), z * (n / b) + x * (n - n / b * b));
        for (long au = 0; a * au <= n && au <= 40000; au++) {
            res = Math.min(res, au * y + (n - a * au) / b * z + (n - a * au) % b * x);
        }
        for (long bu = 0; b * bu <= n && bu <= 40000; bu++) {
            res = Math.min(res, bu * z + (n - b * bu) / a * y + (n - b * bu) % a * x);
        }
        pr(res);
        // pr(dfs(0, 0));
    }

//    long dfs(long cur, long cost) {
//        if (m.containsKey(cur)) return m.get(cur);
//        if (cur == n) return cost;
//        long step1 = dfs(cur + 1, cost + x);
//        long step2 = dfs(cur + a, cost + y);
//        long step3 = dfs(cur + b, cost + z);
//        m.put(cur, Math.min(cost, m.getOrDefault(cur, Long.MAX_VALUE)));
//        return cost;
//    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextLong();
            a = fs.nextLong();
            b = fs.nextLong();
            x = fs.nextLong();
            y = fs.nextLong();
            z = fs.nextLong();
            solve();
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
        new Main().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}