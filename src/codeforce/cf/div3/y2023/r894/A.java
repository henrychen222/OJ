/**
 * 08/24/23 morning
 * https://codeforces.com/contest/1862/problem/0
 */
package codeforce.cf.div3.y2023.r894;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    /*
    1
    1 8
    vikavika
     */
    // Accepted
    void solve(int n, int m, char[][] g) {
        char[] a = {'v', 'i', 'k', 'a'};
        int p = 0;
        for (int j = 0; j < m; j++) {
            boolean find = false;
            for (int i = 0; i < n; i++) {
                if (g[i][j] == a[p]) {
                    find = true;
                    break;
                }
            }
            if (find) {
                p++;
                if (p > 3) break;
            }
        }
        // tr(p);
        pr(p > 3 ? "YES" : "NO");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            char[][] g = new char[n][];
            for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
            solve(n, m, g);
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
        new A().run();
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