/**
 * 12/14/24 morning
 * https://atcoder.jp/contests/abc384/tasks/abc384_a
 */
package atcoder.abc.r384.A;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(int n, char c1, char c2, char[] s) {
        for (int i = 0; i < n; i++) {
            if (s[i] != c1) s[i] = c2;
        }
        pr(new String(s));
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String n = fs.next(), c1 = fs.next(), c2 = fs.next();
        char[] s = fs.next().toCharArray();
        // tr(n, c1, c2, s);
        solve(Integer.parseInt(n), c1.charAt(0), c2.charAt(0), s);
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