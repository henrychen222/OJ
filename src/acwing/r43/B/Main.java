/**
 * 03/19/22 morning
 * https://www.acwing.com/problem/content/4318/
 */
package acwing.r43.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted  04/26/22 evening
    // reference: https://www.acwing.com/solution/content/102190/
    void solve(int n, long bSum, int[] a) {
        long[] res = new long[n];
        long aSum = 0;
        for (int x : a) aSum += x;
        for (int i = 0; i < n; i++) {
            long up = Math.min(Math.min(bSum, a[i]), bSum - n + 1);
            res[i] = Math.max(bSum + a[i] - aSum, 1L) - 1 + a[i] - up;
        }
        outputA(res);
    }

    //////////////////////////////////////////////////////////
    // don't know
    void solve1(int n, long bsum, int[] a) {
//        long[] poss = new long[n];
        long[] res = new long[n];
        long aSum = 0;
        for (int x : a) aSum += x;
        long diff = aSum - bsum - n;
        tr(aSum, a, bsum, "diff", diff);
        for (int i = 0; i < n; i++) {
            res[i] = a[i] - diff;
        }
//        for (int i = 0; i < n; i++) imposs[i] = a[i] - poss[i];
        outputA(res);
    }

    void outputA(long[] a) {
        for (long e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long s = fs.nextLong();
        int[] a = fs.readArray(n);
        solve(n, s, a);
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
        new Main().run();
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