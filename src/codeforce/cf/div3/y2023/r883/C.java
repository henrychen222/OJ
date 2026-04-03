/**
 * 07/07/23 morning
 * https://codeforces.com/contest/1846/problem/C
 */
package codeforce.cf.div3.y2023.r883;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int m, int h, int[][] times) {
        long[][] res = new long[n][];
        for (int i = 0; i < n; i++) {
            long cur = 0, penalty = 0, point = 0;
            for (int x : times[i]) {
                if (cur + x <= h) {
                    cur += x;
                    penalty += cur;
                    point++;
                } else {
                    break;
                }
            }
            // tr(point, penalty);
            res[i] = new long[]{point, penalty, i};
        }
        // tr(res);
        Arrays.sort(res, (x, y) -> {
            if (x[0] != y[0]) return Long.compare(y[0], x[0]);
            return Long.compare(x[1], y[1]);
        });
        // tr(res);
        for (int i = 0; i < n; i++) {
            if (res[i][2] == 0) {
                pr(i + 1);
                break;
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
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt(), h = fs.nextInt();
            int[][] times = new int[n][];
            for (int i = 0; i < n; i++) {
                int[] a = fs.readArray(m);
                shuffleSort(a);
                times[i] = a;
            }
            solve(n, m, h, times);
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