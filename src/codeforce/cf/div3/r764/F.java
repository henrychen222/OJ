/**
 * 01/10/22 noon
 * https://codeforces.com/contest/1624/problem/F
 */
package codeforce.cf.div3.r764;

import java.util.*;
import java.io.*;

public class F {
    static PrintWriter pw;
    FastScanner fs;

    // Accepted --- https://codeforces.com/contest/1624/submission/142297073
    // reference: kmjp, Heltion, cuiaoxiang
    void solve(int n) {
        int low = 1, high = n - 1;
        while (low < high) {
            int mid = low + high + 1 >> 1;
            int c = n - mid % n, k = mid / n + 1;
            pr("+ " + c);
            pw.flush();
            int x = fs.nextInt();
            if ((mid + c) / n == x) {
                low = mid;
            } else {
                high = mid - 1;
            }
            low += c;
            high += c;
        }
        pr("! " + low);
        pw.flush();
    }

    private void run() {
        read_write_file(); // comment this before submission
        fs = new FastScanner();
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
        new F().run();
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