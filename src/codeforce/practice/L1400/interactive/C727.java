/**
 * 11/27/23 night
 * https://codeforces.com/problemset/problem/727/C
 */
package codeforce.practice.L1400.interactive;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/problemset/submission/727/234658187
// reference: https://codeforces.com/blog/entry/47773  +  wifiiii
public class C727 {
    static PrintWriter pw;
    FastScanner fs;

    /*
     a1 + a2 = sum12
     a1 + a3 = sum13
     a2 + a3 = sum23
     a3 = (sum23 - sum12 + sum13) / 2
     */
    private void run() {
        read_write_file(); // comment this before submission
        fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = new int[n + 1];
        int sum12 = ask(1, 2), sum13 = ask(1, 3), sum23 = ask(2, 3);
        a[3] = (sum23 - sum12 + sum13) / 2;
        a[1] = sum13 - a[3];
        a[2] = sum23 - a[3];
        // tr(a[1], a[2], a[3], "---", sum12, sum13, sum23);
        for (int i = 4; i <= n; i++) {
            a[i] = ask(1, i) - a[1];
        }
        // tr(a);
        prt("! ");
        for (int i = 1; i <= n; i++) prt(a[i] + " ");
    }

    int ask(int i, int j) {
        pr("? " + i + " " + j);
        int x = fs.nextInt();
        return x;
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
        new C727().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
        pw.flush(); // interactive
    }

    <T> void prt(T t) {
        pw.print(t);
        pw.flush();
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
