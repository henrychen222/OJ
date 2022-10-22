/**
 * 06/07/22 night
 * https://codeforces.com/problemset/problem/6/C
 */
package codeforce.practice.L1200;

import java.util.*;
import java.io.*;

public class C6 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/6/159911189
    void solve(int n, int[] a) {
        int i = 0, j = n - 1;
        long curA = 0, curB = 0, cntA = 0, cntB = 0;
        while (i < j) {
            if (curA == 0) {
                curA += a[i++];
                cntA++;
            }
            if (curB == 0) {
                curB += a[j--];
                cntB++;
            }
            long move = Math.min(curA, curB);
            curA -= move;
            curB -= move;
            // tr("curA", curA, "curB", curB, "cntA", cntA, "cntB", cntB, "i", i, "j", j);
        }
        // tr("curA", curA, "curB", curB, "cntA", cntA, "cntB", cntB, "i", i, "j", j);
        if (cntA + cntB < n) {
            if (curA <= curB) {
                cntA++;
            } else {
                cntB++;
            }
        }
        pr(cntA + " " + cntB);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
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
        new C6().run();
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