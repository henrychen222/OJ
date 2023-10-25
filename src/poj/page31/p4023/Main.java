/**
 * 03/29/23 afternoon
 * http://poj.org/problem?id=4023
 * http://poj.org/ProblemDescriptions/neerc-2011.pdf (Problem B)
 */
package poj.page31.p4023;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- http://poj.org/showsource?solution_id=24064471
    // reference: https://en.wikipedia.org/wiki/Truncated_binary_encoding
    void solve(int n) {
        for (int x = 0; x < n; x++) {
            pr(TruncatedBinary(x, n));
        }
    }

    String TruncatedBinary(int x, int n) {
        int k = 0, t = n;
        while (t > 1) {
            k++;
            t >>= 1;
        }
        int u = (1 << k + 1) - n;
        return x < u ? toBinaryLen(x, k) : toBinaryLen(x + u, k + 1);
    }

    String toBinaryLen(int x, int len) {
        String s = Integer.toBinaryString(x);
        if (len > s.length()) {
            int k = len - s.length();
            while (k-- > 0) s = "0" + s;
        }
        return s;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        solve(n);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}