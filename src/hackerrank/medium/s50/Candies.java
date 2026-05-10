/**
 * 04/02/26 night 05/10/26 afternoon
 * https://www.hackerrank.com/challenges/candies/problem
 * same problem:
 * https://leetcode.com/problems/candy/
 */
package hackerrank.medium.s50;

import java.util.*;
import java.io.*;

public class Candies {
    static PrintWriter pw;

    // Accepted --- https://www.hackerrank.com/challenges/candies/submissions/code/471829593
    void TwoPassGreedy(int n, int[] a) {
        int[] L = new int[n], R = new int[n];
        Arrays.fill(L, 1);
        Arrays.fill(R, 1);
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) L[i] = L[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > a[i + 1]) R[i] = R[i + 1] + 1;
        }
//        tr(L, R);
        long res = 0;
        for (int i = 0; i < n; i++) res += Math.max(L[i], R[i]);
        pr(res);
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        TwoPassGreedy(n, a);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Candies().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
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
