/**
 * 05/19/23 morning
 * https://codeforces.com/contest/1833/problem/B
 */
package codeforce.cf.div3.y2023.r874;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int k, int[] a, int[] b) {
        int[][] A = new int[n][];
        for (int i = 0; i < n; i++) {
            A[i] = new int[]{a[i], i};
        }
        Arrays.sort(A, (x, y) -> x[0] - y[0]);
        shuffleSort(b);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[A[i][1]] = b[i];
        // tr(res, test(k, a, res));
        outputA(res);
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

    boolean test(int k, int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (Math.abs(a[i] - b[i]) > k) return false;
        }
        return true;
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
            int[] a = fs.readArray(n), b = fs.readArray(n);
            solve(n, k, a, b);
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}