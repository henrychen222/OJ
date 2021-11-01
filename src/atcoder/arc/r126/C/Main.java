/**
 * 09/19/21 morning
 * https://atcoder.jp/contests/arc126/tasks/arc126_c
 */
package atcoder.arc.r126.C;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/arc126/submissions/26004453 763ms
    // reference https://atcoder.jp/contests/arc126/submissions/25986933
    void solve(int n, long k, int[] a) {
        // long sum = Arrays.stream(a).sum(); // wrong, it is int sum
        // long sum = Arrays.stream(a).mapToLong(Long::valueOf).sum();
        long sum = 0;
        for (int x : a) sum += x; // Accepted --- https://atcoder.jp/contests/arc126/submissions/26004516  773ms
        Arrays.sort(a);
        long d = (long) a[n - 1] * n - sum;
        if (k >= d) {
            long res = a[n - 1] + (k - d) / n;
            pr(res);
            return;
        }
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + a[i];
        int res = -1;
        for (int i = 1; i <= a[n - 1]; i++) {
            int li = 0, ri = 0;
            long cur = 0;
            for (int j = i; ; j += i) {
                ri = upper_bound(a, j);
                cur += (long) j * (ri - li) - (pre[ri] - pre[li]);
                li = ri;
                if (j >= a[n - 1]) break;
            }
            // tr(i, cur);
            if (cur <= k) res = i;
        }
        pr(res);
    }

    int upper_bound(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + high >>> 1;
            if (x < a[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        long k = fs.nextLong();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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