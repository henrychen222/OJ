/**
 * 07/02/22 night
 * https://codeforces.com/problemset/problem/1697/B
 */
package codeforce.practice.L900;

import java.util.*;
import java.io.*;

public class B1697 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/1697/162633854
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), q = fs.nextInt();
        int[] a = fs.readArray(n);
        shuffleSort(a);
        a = reverseA(a);
        long[] pre = preSum(a);
        for (int i = 0; i < q; i++) {
            int x = fs.nextInt(), y = fs.nextInt();
            int r = x - 1, l = Math.max(0, x - y);
            long sum = subArraySum(pre, l, r);
            pr(sum);
        }
    }

    long[] preSum(int[] a) {
        int n = a.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + a[i];
        return pre;
    }

    long subArraySum(long[] a, int l, int r) {
        return a[r + 1] - a[l];
    }

    int[] reverseA(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[n - i - 1];
        return b;
    }

    void shuffleSort(int[] a) {
        shuffleArray(a);
        Arrays.sort(a);
    }

    void shuffleArray(int[] a) {
        int n = a.length;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            int randomPos = i + rnd.nextInt(n - i);
            a[i] = a[randomPos];
            a[randomPos] = tmp;
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
        new B1697().run();
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

