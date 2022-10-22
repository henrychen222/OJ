/**
 * 08/26/22 evening
 * https://codeforces.com/problemset/problem/53/C
 */
package codeforce.practice.L1200;

import java.util.*;
import java.io.*;

public class C53 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/53/169749364
    void solve(int n) {
        int[] a = new int[n];
        int x = 1, y = n;
        for (int i = 0; i + 1 < n && x < y; i += 2, x++, y--) {
            a[i] = x;
            a[i + 1] = y;
        }
        // tr(a, x, y);
        if (n % 2 != 0) a[n - 1] = x;
        // tr(a, test(a));
        outputA(a);
    }

    boolean test(int[] a) {
        Set<Integer> se = new HashSet<>(), res = new HashSet<>();
        for (int x : a) se.add(x);
        if (a.length != se.size()) return false;
        for (int i = 1; i < a.length; i++) res.add(a[i] - a[i - 1]);
        if (res.size() != a.length - 1) return false;
        return true;
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
        new C53().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
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
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}