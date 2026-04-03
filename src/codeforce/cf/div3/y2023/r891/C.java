/**
 * 08/07/23 morning
 * https://codeforces.com/contest/1857/problem/C
 */
package codeforce.cf.div3.y2023.r891;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] b) {
        shuffleSort(b);
        int m = b.length;
        int[] a = new int[n];
        Arrays.fill(a, Integer.MIN_VALUE);
        int p = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int v = b[p++];
                a[i] = Math.max(a[i], v);
                a[j] = Math.max(a[j], v);
            }
        }
        // tr(a, test(a), Arrays.equals(test(a), b));
        outputA(a);
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

    int[] test(int[] a) {
        int n = a.length, m = n * (n - 1) / 2, p = 0;
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                b[p++] = Math.min(a[i], a[j]);
            }
        }
        return b;
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
            int n = fs.nextInt();
            int[] b = fs.readArray(n * (n - 1) / 2);
            solve(n, b);
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
        new C().run();
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
