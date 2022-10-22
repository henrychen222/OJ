/**
 * 05/08/22 night
 * https://codeforces.com/problemset/problem/975/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B975 {
    static PrintWriter pw;

    // Accepted https://codeforces.com/problemset/submission/975/156387190
    void solve(int[] a) {
        // tr("a", a);
        long res = 0;
        for (int i = 0; i < 14; i++) {
            if (a[i] != 0) {
                int[] b = Arrays.copyOf(a, 14);
                b[i] = 0; // 先重置0
                move(b, a[i], i);
                long sum = 0;
                for (int x : b) {
                    if (x % 2 == 0) sum += x;
                }
                // tr(b, sum);
                res = Math.max(res, sum);
            }
        }
        pr(res);
    }

    void move(int[] a, int x, int idx) {
        int round = x / 14, rest = x % 14;
        for (int i = 0; i < 14; i++) a[i] += round;
        // tr("rest", rest, a);
        while (rest-- > 0) {
            idx = idx < 13 ? idx + 1 : 0;
            a[idx]++;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(14);
        solve(a);
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
        new B975().run();
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