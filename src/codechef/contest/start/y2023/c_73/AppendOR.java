/**
 * 01/11/23 morning
 * https://www.codechef.com/START73C/problems/APPENDOR
 */
package codechef.contest.start.y2023.c_73;

import java.util.*;
import java.io.*;

class AppendOR {
    static PrintWriter pw;
    int N = 25;

    /*
     0011
     0101
     0110
     0010
  x
     ----
  y  1111
     */
    // Accepted
    void solve(int n, int y, int[] a) {
        // tr(n, y, a);
        int[] f = new int[N];
        int[] fy = new int[N];
        int[] d = new int[N];
        for (int i = 0; i < N; i++) {
            if (checkIthBit(y, i)) fy[N - i - 1]++;
            for (int x : a) {
                if (checkIthBit(x, i)) f[N - i - 1]++;
            }
        }
//        tr(f);
//        tr(fy);
        for (int i = N - 1; i >= 0; i--) {
            if (fy[i] == 0) {
                if (f[i] == 0) {
                } else {
                    pr(-1);
                    return;
                }
            } else {
                if (f[i] == 0) {
                    d[i] = 1;
                } else {
                }
            }
        }
//        tr(d);
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (d[i] == 1) res += 1 << N - i - 1;
        }
        pr(res);
    }

    void solve1(int n, int y, int[] a) {
        tr(n, y, a);
        int cur = 0;
        for (int x : a) cur |= x;
        int[] d = new int[N];
        for (int i = 0; i < N; i++) {
            if (checkIthBit(cur, i)) {
                if (checkIthBit(y, i)) { // cur = 1 y = 1     1 | 0 -> 1  x = 0
                } else { // cur = 1  y = 0     1 | 0 -> 1   1 | 1 -> 1
                    pr(-1);
                    return;
                }
            } else {
                if (checkIthBit(y, i)) { // cur = 0  y = 1     0 | 1 -> 1   x = 1
                    d[i] = 1;
                } else { // 0 0    cur = 0  y = 0       0 | 0 -> 0   x = 0
                }
            }
        }
        tr(d);
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (d[i] == 1) res += 1 << N - i - 1;
        }
        pr(res);
    }

    boolean checkIthBit(int x, int i) {
        return (x & (1 << i)) != 0;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), y = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, y, a);
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
        new AppendOR().run();
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
