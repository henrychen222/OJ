/**
 * 07/27/23 noon
 * https://codeforces.com/contest/1849/problem/C
 */
package codeforce.ecf.y2023.r152;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1849/submission/216009999
    // rolling hash problem, reference: jiangly
    void solve(int n, int m, char[] s, int[][] b) {
        Set<String> se = new HashSet<>();
        int[] next = new int[n + 1], last = new int[n + 1];
        Arrays.fill(next, n);
        Arrays.fill(last, -1);
        for (int i = n - 1; i >= 0; i--) {
            next[i] = s[i] == '1' ? i : next[i + 1];
        }
        for (int i = 0; i < n; i++) {
            last[i + 1] = s[i] == '0' ? i : last[i];
        }
//        tr(next);
//        tr(last);
        for (int[] e : b) {
            int l = e[0] - 1, r = e[1] - 1;
            l = next[l];
            r = last[r + 1];
            if (l > r) {
                l = r = -1;
            }
            se.add(l + " " + r);
        }
        // tr(se);
        pr(se.size());
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            char[] s = fs.next().toCharArray();
            int[][] b = new int[a[1]][];
            for (int i = 0; i < a[1]; i++) b[i] = fs.readArray(2);
            solve(a[0], a[1], s, b);
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
