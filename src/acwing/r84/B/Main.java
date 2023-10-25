/**
 * 12/31/22 morning
 * https://www.acwing.com/problem/content/4792/
 */
package acwing.r84.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        long[] preA = preSum(a);
        Arrays.sort(a);
        long[] preB = preSum(a);
        int m = fs.nextInt();
        for (int i = 0; i < m; i++) {
            int[] e = fs.readArray(3);
            long res;
            if (e[0] == 1) {
                res = subArraySum(preA, e[1] - 1, e[2] - 1);
            } else {
                res = subArraySum(preB, e[1] - 1, e[2] - 1);
            }
            pr(res);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}