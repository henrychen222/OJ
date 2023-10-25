/**
 * 03/11/23 night
 * https://codeforces.com/problemset/problem/710/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B710 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/710/197032510
    void solve(int n, int[] a) {
        shuffleSort(a);
        if (n % 2 == 0) {
            int l = n / 2 - 1, r = n / 2;
            pr(sumOfDis(n, l, a) <= sumOfDis(n, r, a) ? a[l] : a[r]);
        } else {
            pr(a[n / 2]);
        }
    }

    long sumOfDis(int n, int p, int[] a) {
        long sum = 0;
        for (int i = p + 1; i < n; i++) sum += Math.abs(a[i] - a[p]);
        for (int i = p - 1; i >= 0; i--) sum += Math.abs(a[i] - a[p]);
        return sum;
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
        new B710().run();
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