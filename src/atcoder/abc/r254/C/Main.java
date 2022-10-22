/**
 * 06/04/22 morning
 * https://atcoder.jp/contests/abc254/tasks/abc254_c
 */
package atcoder.abc.r254.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/abc254/submissions/32248840
    // reference: https://atcoder.jp/contests/abc254/submissions/32206480
    void solve(int n, int k, int[] a) {
        for (int i = 0; i < k; i++) {
            List<Integer> b = new ArrayList<>();
            for (int j = i; j < n; j += k) b.add(a[j]);
            Collections.sort(b);
            int p = 0;
            for (int j = i; j < n; j += k) a[j] = b.get(p++);
        }
        // tr(a);
        pr(isAscending(a) ? "Yes" : "No");
    }

    boolean isAscending(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }

    // WA
    void solve1(int n, int k, int[] a) {
        for (int i = 1; i < n; ) {
            if (a[i - 1] > a[i]) {
                // tr(a, a[i - 1], a[i]);
                if (i + k < n) {
                    if (a[i - 1] <= a[i + k]) {
                        // swap(a, i, i + k);
                        i += 2;
                        continue;
                    }
                }
                if (i - k >= 0) {
                    if (a[i - 1] <= a[i - k]) {
                        // swap(a, i, i - k);
                        i += 2;
                        continue;
                    }
                }
                pr("No");
                return;
            } else {
                i++;
            }
        }
        // tr(a);
        pr("Yes");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, k, a);
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