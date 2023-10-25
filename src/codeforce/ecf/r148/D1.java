/**
 * 05/12/23 afternoon
 * https://codeforces.com/contest/1832/problem/D1
 */
package codeforce.ecf.r148;

import java.util.*;
import java.io.*;

public class D1 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1832/submission/205653292
    // reference: tourist
    // Accpeted --- https://codeforces.com/contest/1832/submission/205654142 jiangly
    void solve(int n, int q, int[] a, int[] b) {
        shuffleSort(a);
        int[] origin = Arrays.copyOf(a, n);
        for (int i = 0; i < q; i++) {
            a = Arrays.copyOf(origin, n);
            // tr(a);
            for (int j = 0; j < n; j++) {
                if (b[i] == 0) break;
                if (b[i] % 2 == 0 && j == n - 1) break;
                a[j] += b[i];
                b[i]--;
            }
            b[i] /= 2;
            shuffleSort(a);
            long diff = 0;
            for (int j = 0; j < n; j++) diff += a[j] - a[0];
            int res = a[0];
            if (b[i] > diff) {
                b[i] -= diff;
                res -= (b[i] + n - 1) / n;
            }
            pr(res);
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
        new D1().run();
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
