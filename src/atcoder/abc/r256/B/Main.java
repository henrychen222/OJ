/**
 * 06/18/22 morning
 * https://atcoder.jp/contests/abc256/tasks/abc256_b
 */
package atcoder.abc.r256.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/abc256/submissions/32579462
    // reference: https://atcoder.jp/contests/abc256/editorial/4144
    void solve(int n, int[] a) {
        long remove = 0;
        int[] square = new int[4];
        for (int x:a) {
            int [] tmp = new int[4];
            square[0] = 1;
            for (int i = 0; i < 4; i++) {
                if (square[i] == 1) {
                    int next = i + x;
                    if (i + x >= 4) {
                        remove++;
                    } else {
                        tmp[next] = 1;
                    }
                }
            }
            square = tmp;
        }
        pr(remove);
    }

    //////////////////////////////////////////////////////////
    // WA
    /*
       1 1 3 2

      [1 0 0 0]   i = 0  a[i] = 1  index <= i move 1     [0 1 0 0]
      [1 1 0 0]   i = 1  a[i] = 1  index <= i move 1     [0 1 1 0]
      [1 1 1 0]   i = 2  a[i] = 3  index <= i move 3     [0 0 0 1]   remove = 2
      [1 0 0 1]   i = 3  a[i] = 2  index <= i move 2     [0 0 1 0]   remove = 1
     */
    void solve1(int n, int[] a) {
        long res = 0;
        int[] square = new int[n];
        for (int i = 0; i < n; i++) {
            square[0] = 1;
            // tr("begin square", square);
            long remove = 0;
            for (int j = i; j >= 0; j--) {
                if (square[j] == 1) {
                    int next = j + a[i];
                    if (next >= n) {
                        // tr(j, a[i], j + a[i]);
                        remove++;
                    } else {
                        square[next] = 1;
                    }
                    square[j] = 0;
                }
            }
            // tr("after square", square, "remove", remove);
            res += remove;
        }
        pr(res);
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
        new Main().run();
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