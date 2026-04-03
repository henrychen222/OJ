/**
 * 08/31/24 night  12/14/24 morning
 * https://codeforces.com/problemset/problem/479/C
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class C479 {
    static PrintWriter pw;

    // Accepted https://codeforces.com/problemset/submission/479/296474772
    void solve(int n, int[][] d) {
        Arrays.sort(d, (x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
            return x[1] - y[1];
        });
//        tr(d);
        int cur = d[0][1];
        for (int i = 1; i < d.length; i++) {
            if (d[i][1] >= cur) {
                cur = d[i][1];
            } else {
                cur = d[i][0];
            }
        }
        pr(cur);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] interval = new int[n][];
        for (int i = 0; i < n; i++) interval[i] = fs.readArray(2);
        solve(n, interval);
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
        new C479().run();
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
