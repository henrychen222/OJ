/**
 * 01/03/22 morning
 * https://codeforces.com/contest/1779/problem/B
 */
package codeforce.hello.r2023;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted
    void solve(int n) {
        if (n == 3) {
            pr("NO");
            return;
        }
        pr("YES");
        int[] a = new int[n];
        if (n % 2 == 0) {
            int cur = 1;
            for (int i = 0; i < n; i++) {
                a[i] = cur;
                cur *= -1;
            }
        } else {
            int x = -n / 2, y = -x - 1;
            for (int i = 0; i < n; i++) a[i] = i % 2 == 0 ? y : x;
        }
        outputA(a);
        // tr(test(a));
    }

    // WA
    void solve1(int n) {
        if (n % 2 != 0) {
            pr("NO");
            return;
        }
        pr("YES");
        int[] a = new int[n];
        int cur = 1;
        for (int i = 0; i < n; i++) {
            a[i] = cur;
            cur *= -1;
        }
        outputA(a);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    boolean test(int[] a) {
        int n = a.length, sum = Arrays.stream(a).sum();
        for (int i = 0; i + 1 < n; i++) {
            if (a[i] + a[i + 1] != sum) return false;
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}