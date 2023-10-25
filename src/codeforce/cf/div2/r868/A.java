/**
 * 04/27/23 morning
 * https://codeforces.com/contest/1823/problem/0
 */
package codeforce.cf.div2.r868;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Pretests passed
    void solve(int n, int k) {
        for (int pos = 0; pos <= n; pos++) {
            int neg = n - pos;
            long ones = cal(pos) + cal(neg);
            if (ones == k) {
                pr("YES");
                int[] a = new int[n];
                Arrays.fill(a, -1);
                for (int t = 0; t < pos; t++) a[t] = 1;
                outputA(a);
                return;
            }
        }
        pr("NO");
    }

    long cal(int n) {
        return (long) n * (n - 1) / 2;
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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
        new A().run();
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