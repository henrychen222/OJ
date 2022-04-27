/**
 * 03/03/22 afternoon
 * https://www.codechef.com/START28B/problems/PERMXORITY
 */
package codechef.contest.start.r28;

import java.util.*;
import java.io.*;

class PermutationXority {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/59589124
    // reference: https://discuss.codechef.com/t/permxority-editorial/99633
    void solve(int n) {
        int[] a = new int[n];
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) a[i] = i + 1;
        } else {
            if (n == 2) {
                pr(-1);
                return;
            }
            a[0] = 2;
            a[1] = 3;
            a[2] = 1;
            for (int i = 3; i < n; i++) a[i] = i + 1;
        }
        // tr(test(a));
        outputA(a);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    boolean test(int[] a) {
        int n = a.length, res = 0;
        for (int i = 1; i < n; i++) {
            res ^= Math.abs(a[i] - a[i - 1]);
            tr(res);
        }
        return res == 0;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new PermutationXority().run();
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
