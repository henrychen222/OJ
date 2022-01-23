/**
 * 01/10/22 morning
 * https://www.codechef.com/problems/PERMUT2
 */
package codechef.practice.beginner;

import java.util.*;
import java.io.*;

class AmbiguousPermutations {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/56184148
    void solve(int n, int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) m.put(a[i], i);
        int[] inv = new int[n];
        for (int i = 0; i < n; i++) inv[i] = m.get(i + 1) + 1;
        // tr(inv);
        for (int i = 0; i < n; i++) {
            if (a[i] != inv[i]) {
                pr("not ambiguous");
                return;
            }
        }
        pr("ambiguous");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = -1;
        int[] a = new int[0];
        for (int i = 0; n != 0; i++) {
            if (i % 2 == 0) {
                n = fs.nextInt();
            } else {
                a = fs.readArray(n);
                solve(n, a);
            }
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
        new AmbiguousPermutations().run();
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

        char nextChar() {
            return next().charAt(0);
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
