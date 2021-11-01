/**
 * 09/05/21 evening
 * https://codeforces.com/contest/1567/problem/D
 */

package codeforce.cf.div2.r742;

import java.util.*;
import java.io.*;

public class D {

    static PrintWriter pw;

    // Accepted ---- https://codeforces.com/contest/1567/submission/128003268
    // reference: Tlatoani
    void solve(long s, long n) {
        List<Long> res = new ArrayList<>();
        while (n-- > 0) {
            if (n == 0) {
                res.add(s);
            } else {
                long rem = s - n, x = 1;
                while (rem >= 10) {
                    rem /= 10;
                    x *= 10;
                }
                res.add(x);
                s -= x;
            }
        }
        // tr(res);
        output(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long s = fs.nextLong();
            long n = fs.nextLong();
            solve(s, n);
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
        new D().run();
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

    void output(List<Long> l) {
        for (long x : l) {
            pw.print(x + " ");
        }
        pr("");
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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