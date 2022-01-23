/**
 * 12/1/21 morning
 * https://codeforces.com/contest/1613/problem/B
 */
package codeforce.ecf.r118;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1613/submission/137934153
    void solve(int n, int[] a) {
        shuffleArray(a);
        Arrays.sort(a);
        // tr(a);
        int m = n / 2;
        for (int i = 0; i < m; i++) {
            pr(a[i + 1] + " " + a[0]);
        }
    }

    // TLE
    void solve1(int n, int[] a) {
        shuffleArray(a);
        Arrays.sort(a);
        int[] exist = new int[1000001];
        for (int x : a) exist[x] = 1;
        int m = n / 2;
        a = reverse(a);
        // tr(a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = a[i], y = a[j], mod = x % y;
                if (exist[mod] == 0) {
                    pr(x + " " + y);
                    m--;
                    if (m == 0) return;
                }
            }
        }
    }

    int[] reverse(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) res[n - i - 1] = a[i];
        return res;
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
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}

