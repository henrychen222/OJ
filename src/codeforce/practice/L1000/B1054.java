/**
 * 11/08/21 morning
 * https://codeforces.com/problemset/problem/1054/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class B1054 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/1054/134667994
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        int max = 0;
        for (int x : a) max = Math.max(max, x);
        Set<Integer> visit = new HashSet<>();
        for (int i = 0; i < n; i++) {
            visit.add(a[i]);
            if (a[i] > i) {
                pr(i + 1);
                return;
            } else {
                if (a[i] > 0 && !visit.contains(a[i] - 1)) { // 前一个数没有出现也不行
                    pr(i + 1);
                    return;
                }
            }
        }
        pr(-1);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new B1054().run();
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
