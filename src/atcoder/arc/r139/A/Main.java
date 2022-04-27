/**
 * 04/24/22 morning
 * https://atcoder.jp/contests/arc139/tasks/arc139_a
 */
package atcoder.arc.r139.A;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/arc139/submissions/31248354
    // reference: https://atcoder.jp/contests/arc139/submissions/31236428 uwi
    void solve(int n, int[] t) {
        long res = 1L << t[0];
        for (int i = 1; i < n; i++) {
            res = (res >> t[i]) + 1 << t[i];
            if (Long.numberOfTrailingZeros(res) != t[i]) res += 1L << t[i];
        }
        pr(res);
    }

    // Accepted --- https://atcoder.jp/contests/arc139/submissions/31248116
    // reference: https://atcoder.jp/contests/arc139/submissions/31236497 kmjp
    void solve2(int n, int[] t) {
        long pre = 0;
        for (int i = 0; i < n; i++) {
            long cur = 1L << t[i];
            pre++;
            pre = (pre + cur - 1) / cur * cur;
            if (pre % (2 * cur) == 0) pre += cur;
        }
        pr(pre);
    }

    //////////////////////////////////////////////////////////////////////
    /*
     10000
     11000
     11100
     11110
     11111

         100
      100111
      101100
      110100
      111111
      110000
     1010100
     1010000
     */
    // WA https://atcoder.jp/contests/arc139/submissions/31244710
    void solve1(int n, int[] t) {
        // tr(Integer.toString(3, 2), Integer.toString(6, 2), Integer.toString(8, 2), Integer.toString(12, 2));
        // tr(Integer.toString(80, 2), (1 << 4) + (1 << 6));
        long res = 0;
        if (n == 1) {
            pr(1L << t[0]);
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (t[i - 1] >= t[i]) {
                // tr(t[i - 1], t[i]);
                long pre = 1L << t[i - 1], cur = 1L << t[i];
                // long pre = 1L << i - 1, cur = 1L << i;
                if (!used.contains(i - 1)) {
                    res += pre;
                    used.add(i - 1);
                }
                if (!used.contains(i)) {
                    res += cur;
                    used.add(i);
                }
            }
        }
//        tr(used);
        pr(res);
    }

    boolean test(int[] a, int[] t) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (Integer.numberOfTrailingZeros(a[i]) != t[i]) return false;
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] t = fs.readArray(n);
        solve(n, t);
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