/**
 * 06/25/22 morning
 * https://atcoder.jp/contests/abc257/tasks/abc257_b
 */
package atcoder.abc.r257.B;

import java.util.*;
import java.io.*;

// Accepted
class Main {
    static PrintWriter pw;

    /*
                                           [1, 0, 1, 1, 0]

      3   idx = 3  rightmost = 3    move   [1, 0, 1, 0, 1]
      3   idx = 4  rightmost = 4    keep   [1, 0, 1, 0, 1]
      1   idx = 1  rightmost = 4    move   [0, 1, 1, 0, 1]
      1   idx = 1  rightmost = 4    keep   [0, 1, 1, 0, 1]
      2   idx = 2  rightmost = 4    move   [0, 1, 0, 1, 1]
     */
    void solve(int n, int k, int q, int[] a, int[] b) {
        int[] square = new int[n];
        for (int x : a) square[x - 1] = 1;
        for (int piece : b) {
            // tr("begin", square);
            int rightmost = n - 1;
//            for (int i = n - 1; i >= 0; i--) {
//                if (square[i] == 1) {
//                    rightmost = i;
//                    break;
//                }
//            }
            int j, cnt;
            for (j = 0, cnt = 0; j < n; j++) {
                if (square[j] == 1) {
                    cnt++;
                    if (cnt == piece) {
                        break;
                    }
                }
            }
            if (j != rightmost && j + 1 < n && square[j + 1] == 0) {
                square[j + 1] = 1;
                square[j] = 0;
            }
            // tr("idx", j, "rightmost", rightmost, square);
        }
        // tr(square);
        for (int i = 0; i < n; i++) {
            if (square[i] == 1) pw.print((i + 1) + " ");
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt(), q = fs.nextInt();
        int[] a = fs.readArray(k), b = fs.readArray(q);
        solve(n, k, q, a, b);
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