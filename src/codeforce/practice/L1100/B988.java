/**
 * 03/06/22 night
 * https://codeforces.com/problemset/problem/988/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B988 {
    static PrintWriter pw;

    // Accepted ---- https://codeforces.com/problemset/submission/988/148679123
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        String[] a = fs.readArray(n);
        Arrays.sort(a, (x, y) -> x.length() - y.length());
        for (int i = 1; i < n; i++) {
            if (a[i - 1].length() == a[i].length()) {
                if (!a[i - 1].equals(a[i])) {
                    pr("NO");
                    return;
                }
            } else {
                if (!a[i].contains(a[i - 1])) {
                    pr("NO");
                    return;
                }
            }
        }
        pr("YES");
        for (String e : a) pr(e);
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
        new B988().run();
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

        String[] readArray(int n) {
            String[] a = new String[n];
            for (int i = 0; i < n; i++) a[i] = next();
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