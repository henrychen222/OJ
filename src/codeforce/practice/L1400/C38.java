/**
 * 03/10/23 night
 * https://codeforces.com/problemset/problem/38/C
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class C38 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/38/196910395
    // reference: uwi
    void solve(int n, int l, int[] a) {
        int max = Arrays.stream(a).max().getAsInt(), res = 0;
        for (int i = l; i <= max; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += a[j] / i * i;
            }
            res = Math.max(res, sum);
        }
        pr(res);
    }

    // WA
    void solve1(int n, int l, int[] a) {
        int maxArea = 0, maxCut = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] >= l && a[j] >= l) {
                    int area = a[i] * a[j], cut = cut(a[i], a[j], l);
                    // tr(a[i], a[j], "area", area, "cut", cut);
                    if (cut > maxCut) {
                        maxCut = cut;
                        maxArea = area;
                    }
                }
            }
        }
        pr(maxArea);
    }

    int cut(int x, int y, int l) {
        int res = 0;
        if (x % l == 0) {
            if (y % l == 0) {
                res = Math.max(res, x / l * y / l);
            } else {
                res = Math.max(res, x / l);
            }
        } else {
            if (y % l == 0) res = Math.max(res, y / l);
        }
        return res;
    }


    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), l = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, l, a);
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
        new C38().run();
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