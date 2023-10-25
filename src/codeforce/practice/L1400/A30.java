/**
 * 01/11/23 night
 * https://codeforces.com/problemset/problem/30/A
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class A30 {
    static PrintWriter pw;

    /*
     -5 -5 3
     1 512 9
     */
    // Accepted --- https://codeforces.com/problemset/submission/30/188969077
    void solve(int a, int b, int n) {
        if (a == 0) {
            pr(b == 0 ? 1 : "No solution");
            return;
        } else if (b == 0) {
            pr(0);
            return;
        }
        double v = (double) b / a;
        if (!isInteger(v)) {
            pr("No solution");
            return;
        }
        List<Double> d = new ArrayList<>();
        // tr(v, d);
        for (int i = 0; i < 5; i++) d.add(NthRoot(v, n)); // result maybe different, random()
        for (double res : d) {
            if (isInteger(res)) {
                pr((int) res);
                return;
            }
        }
        pr("No solution");
    }

    // reference: https://stackoverflow.com/questions/32553108/calculating-nth-root-in-java-using-power-method
    double NthRoot(double x, double root) {  // res ** n = x;
        double xPre = Math.random() % 10, error = 0.0000001, delX = 2147483647, res = 0.0;
        while (delX > error) {
            res = ((root - 1.0) * xPre + x / Math.pow(xPre, root - 1)) / root;
            delX = Math.abs(res - xPre);
            xPre = res;
        }
        return res;
    }

    boolean isInteger(double x) {
        return x == (int) x;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(3);
        solve(a[0], a[1], a[2]);
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
        new A30().run();
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