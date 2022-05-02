/**
 * 04/30/22 morning
 * https://www.acwing.com/problem/content/4417/
 */
package acwing.r49.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] a) {
        // getAllSubsequence(a);
        pr(maxOddSumSubsequence(a));
    }

    /*
     reference:
     https://www.geeksforgeeks.org/subsequence-maximum-odd-sum/ (use)
     */
    long maxOddSumSubsequence(int[] a) {
        int n = a.length;
        int min_odd = Integer.MAX_VALUE;
        boolean isOdd = false;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) sum += a[i];
            if (a[i] % 2 != 0) {
                isOdd = true;
                min_odd = Math.min(min_odd, Math.abs(a[i]));
            }
        }
        if (!isOdd) return -1;
        if (sum % 2 == 0) sum -= min_odd;
        return sum;
    }

    void getAllSubsequence(int[] a) {
        int n = a.length;
        long res = Long.MIN_VALUE;
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> sub = new ArrayList<>();
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sub.add(a[j]);
                    sum += a[j];
                }
            }
            tr("sub", sub, "sum", sum);
            if (sum % 2 != 0) {
                res = Math.max(res, sum);
            }
        }
        tr("res", res);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}