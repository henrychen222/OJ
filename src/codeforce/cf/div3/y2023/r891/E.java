/**
 * 08/07/23 night
 * https://codeforces.com/contest/1857/problem/E
 */
package codeforce.cf.div3.y2023.r891;

import java.util.*;
import java.io.*;

public class E {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1857/submission/217800783
    // reference neal
    void solve(int n, int[] a) {
        int[] b = Arrays.copyOf(a, n);
        shuffleSort(b);
        long[] pre = preSum(b), res = new long[n];
        for (int i = 0; i < n; i++) {
            int idx = lower_bound(b, a[i]);
            res[i] = (long) idx * a[i] - pre[idx] + subArraySum(pre, idx, n - 1) - (long) (n - idx) * a[i] + n;
        }
        outputA(res);
    }

    int lower_bound(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + high >>> 1;
            if (a[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    long[] preSum(int[] a) {
        int n = a.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + a[i];
        return pre;
    }

    long subArraySum(long[] a, int l, int r) {
        return a[r + 1] - a[l];
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

    void outputA(long[] a) {
        for (long e : a) pw.print(e + " ");
        pr("");
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
        new E().run();
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
