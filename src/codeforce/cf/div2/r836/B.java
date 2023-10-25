/**
 * 11/25/22 morning
 * https://codeforces.com/contest/1758/problem/B
 */
package codeforce.cf.div2.r836;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Pretests passed
    void solve(int n) {
        int[] a = new int[n];
        if (n % 2 == 0) {
            Arrays.fill(a, 2);
            a[0] = 3;
            a[1] = 1;
        } else {
            Arrays.fill(a, 1);
        }
        // tr(a, test(a));
        outputA(a);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    boolean test(long[] a) {
        long sum = 0, xor = 0;
        for (long x : a) {
            sum += x;
            xor ^= x;
        }
        // tr(xor, sum / a.length);
        return xor * a.length == sum;
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
        new B().run();
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