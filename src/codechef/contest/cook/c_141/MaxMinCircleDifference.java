/**
 * 05/01/22 morning
 * https://www.codechef.com/COOK141C/problems/MAXMINCRCDIF
 */
package codechef.contest.cook.c_141;

import java.util.*;
import java.io.*;

class MaxMinCircleDifference {
    static PrintWriter pw;

    /*
       reference:
       https://www.codechef.com/viewsolution/64015522
       https://discuss.codechef.com/t/maxmincrcdif-editorial/100890

       Accepted --- https://www.codechef.com/viewsolution/64062177 (050122 evening)
     */
    void solve(int n, int[] a) {
        Arrays.sort(a);
        int h = n / 2;
        List<Integer> res = new ArrayList<>();
        if (n % 2 == 0) {
            List<Integer> ia = new ArrayList<>();
            for (int i = 0; i < h; i++) ia.add(i % 2 == 0 ? i : i + h);
            for (int i = h - 1; i >= 0; i--) ia.add(i % 2 == 0 ? i + h : i);
            int min = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i < n; i++) {
                if (i + h - 1 < n) {
                    int v = a[i + h - 1] - a[i];
                    if (v < min) {
                        min = v;
                        idx = i;
                    }
                }
            }
            for (int i : ia) res.add(a[(i + idx) % n]);
        } else {
            res.add(a[0]);
            res.add(a[h]);
            res.add(a[n - 1]);
            for (int i = h - 1; i > 0; i--) {
                res.add(a[i]);
                res.add(a[i + h]);
            }
        }
        outputL(res);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
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
        new MaxMinCircleDifference().run();
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