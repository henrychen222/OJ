/**
 * 02/22/22 evening
 * https://codeforces.com/problemset/problem/347/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B347 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/347/submission/147382283
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) m.put(a[i], i);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == i) cnt++;
        }
        int plus = 0;
        for (int i = 0; i < n; i++) {
            int j = m.get(i), preCnt = 0, afterCnt = 0;
            if (a[i] == i) preCnt++;
            if (a[j] == j) preCnt++;
            if (a[i] == j) afterCnt++;
            if (a[j] == i) afterCnt++;
            plus = Math.max(plus, afterCnt - preCnt);
        }
        pr(cnt + plus);
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
        new B347().run();
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