/**
 * 03/10/22 morning
 * https://codeforces.com/contest/1651/problem/B
 */
package codeforce.ecf.r124;

import java.util.*;
import java.io.*;

// Accepted
public class B {
    static PrintWriter pw;

    /*
      (a + b) < 2 * |a-b|
     */
    void solve(int n) {
        int[] a = new int[n];
        a[0] = 1;
        int max = (int) 1e9;
        for (int i = 1; i < n; i++) {
            if (3L * a[i - 1] > max) {
                pr("NO");
                return;
            }
            a[i] = 3 * a[i - 1];
        }
        pr("YES");
        outputA(a);
        // tr(test(a));
    }

    void solve1(int n) {
//        int[] t = {31, 4, 159};
//        tr(test(t));

//        if (n % 2 == 0 && n != 2) {
//            pr("NO");
//            return;
//        }
        if (n > 3) {
            pr("NO");
            return;
        }
        int[] a = new int[n];
        int r = (int) 1e9, l = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a[i] = l;
                l += 2;
            } else {
                a[i] = r;
                r--;
            }
        }
        pr("YES");
        outputA(a);
        tr(test(a));
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    boolean test(int[] a) { // no decrease
        long sum = 0;
        for (int x : a) sum += x;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long updateSum = sum - a[i] - a[j] + 2L * Math.abs(a[i] - a[j]);
                tr(a[i], a[j], Math.abs(a[i] - a[j]), "sum", sum, "updateSum", updateSum);
                if (updateSum < sum) return false; // should not decrease
            }
        }
        return true;
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

