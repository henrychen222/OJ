/**
 * 05/12/23 afternoon
 * https://codeforces.com/contest/1832/problem/D2
 */
package codeforce.ecf.r148;

import java.util.*;
import java.io.*;

public class D2 {
    static PrintWriter pw;
    final long inf = (long) 1e18;

    // Accepted --- https://codeforces.com/contest/1832/submission/205654110
    // reference: jiangly
    void solve(int n, int q, int[] a, int[] b) {
        long sum = 0;
        for (int x : a) sum += x;
        shuffleSort(a);
        long[] f = new long[n + 1];
        Arrays.fill(f, inf);
        for (int i = 0; i < n; i++) f[i + 1] = Math.min(f[i] + 1, a[i] + 1);
        for (int k : b) {
            if (k < n) {
                pr(Math.min(f[k], a[k]));
            } else {
                long res;
                long cur = sum;
                if ((k - n) % 2 == 0) {
                    res = f[n] + k - n;
                    cur += (long) n * (k + k - n + 1) / 2 - (k - n) / 2;
                } else {
                    res = Math.min(a[n - 1], f[n - 1] + k - (n - 1));
                    cur += (long) (n - 1) * (k + k - n + 2) / 2 - (k - n + 1) / 2;
                }
                res = Math.min(res, cur >= 0 ? cur / n : (cur - n + 1) / n);
                pr(res);
            }
        }
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

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), q = fs.nextInt();
        int[] a = fs.readArray(n), b = fs.readArray(q);
        solve(n, q, a, b);
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
        new D2().run();
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
