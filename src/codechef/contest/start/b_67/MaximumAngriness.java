/**
 * 11/30/22 morning
 * https://www.codechef.com/START67B/problems/MAXAGRY
 */
package codechef.contest.start.b_67;

import java.util.*;
import java.io.*;

// Accepted
class MaximumAngriness {
    static PrintWriter pw;

    /*
     [1, 2, 3, 4, 5, 6, 7, 8]  k = 2
     [8, 7, 3, 4, 5, 6, 2, 1]
      (7 + 6) + 2 + 2 + 2 + 2 + (1)

      [9, 8, 7, 4, 5, 6, 3, 2, 1]  k = 3
      (8 + 7 + 6) + 3 + 3 + 3 + (2 + 1)
     */
    void solve(int n, int k) {
        int h = n / 2;
        if (k >= h) {
            // tr("all");
            pr(all(n - 1));
        } else {
            int start = n - 1, end = start - k + 1, middle = n - k * 2, rest = n - 1 - middle - (start - end + 1);
            // tr(start, end, sumOfRange(end, start), "middle", middle, "rest", rest);
            pr(sumOfRange(end, start) + (long) middle * k + sumOfRange(1, rest));
        }
        // test(n, k);
    }

    void test(int n, int k) {
        int[] a = new int[n];
        int h = n / 2;
        for (int i = 0; i < n; i++) a[i] = i + 1;
        int need = Math.min(h, k);
        tr(need, h, k);
        for (int i = n - 1; need > 0; i--) {
            swap(a, n - i - 1, i);
            need--;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    // tr(a[i], a[j]);
                    res++;
                }
            }
        }
        tr("after", a, "res", res);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    long sumOfRange(long l, long r) {
        return (l + r) * (r - l + 1) / 2;
    }

    long all(int n) {
        return (long) n * (n + 1) / 2;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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
        new MaximumAngriness().run();
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
