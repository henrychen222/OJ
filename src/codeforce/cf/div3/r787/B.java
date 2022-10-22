/**
 * 05/05/22 morning
 * https://codeforces.com/contest/1675/problem/B
 */
package codeforce.cf.div3.r787;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    /*
     3 6 5
       3
     1

     2 8 7 5
         3
       4
       2
     1

      8 26 5 21 10
             10
             5
           2
        13
        6
        3
        1
      4
      2
      1
      0
     */
    // Accepted
    void solve(int n, int[] a) {
        // tr(n, a, 1 / 2, 0 / 2);
        long res = 0;
        for (int i = n - 1; i > 0; i--) {
            if (a[i - 1] >= a[i]) {
                if (a[i] == 0) {
                    pr(-1);
                    return;
                }
                int[] d = findSmaller(a[i - 1], a[i]);
                a[i - 1] = d[0];
                res += d[1];
            }
        }
        // tr("final", a);
        pr(res);
    }

    int[] findSmaller(int x, int t) {
        int step = 0;
        while (x >= t) {
            x /= 2;
            step++;
        }
        return new int[]{x, step};
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}