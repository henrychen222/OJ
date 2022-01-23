/**
 * 01/23/21 morning
 * https://www.codechef.com/COOK137C/problems/MERGEDLIS
 */
package codechef.contest.cook.c_137;

import java.util.*;
import java.io.*;

class MergedLIS {
    static PrintWriter pw;

    /*
      reference: https://www.codechef.com/viewsolution/56874690
      Accepted --- https://www.codechef.com/viewsolution/56985457
      TLE --- https://www.codechef.com/viewsolution/56984052 (LIS_COVER_EQUAL)
     */
    //
    void solve(int n, int m, int[] a, int[] b) {
        int lisA = LIS_COVER_EQUAL_FAST(a), lisB = LIS_COVER_EQUAL_FAST(b);
        int[] c = new int[n + m];
//        for (int i = 0; i < n; i++) c[i] = a[i];
//        for (int i = 0; i < m; i++) c[n + i] = b[i];
        pr(lisA + lisB);
    }

    void test(int[] c) {
        int n = c.length;
        Arrays.sort(c);
        int res = 0, cnt = 0;
        int[] reversedC = reverseA(Arrays.copyOf(c, n));
        tr(c, reversedC);
        while (true) {
            int lis = LIS_COVER_EQUAL(c);
            res = Math.max(res, lis);
            next_permutation(c);
            cnt++;
            boolean equal = Arrays.equals(c, reversedC);
            tr(res, c, equal);
            if (equal) break;
        }
        tr(res, cnt);
    }

    int[] reverseA(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[n - i - 1];
        return b;
    }

    boolean next_permutation(int[] a) { // array inside can be char ('0' ~ '9', 'a' ~ 'z') and int[]
        int n = a.length, i, j;
        for (i = n - 2; i >= 0 && a[i] >= a[i + 1]; i--) ;
        if (i == -1) return false;
        for (j = i + 1; j < n && a[i] < a[j]; j++) ;
        swap(a, i, j - 1);
        for (int p = i + 1, q = n - 1; p < q; p++, q--) swap(a, p, q);
        return true;
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    int LIS_COVER_EQUAL_FAST(int[] a) {
        int n = a.length, res = 0;
        int[] tail = new int[n];
        for (int x : a) {
            int low = 0, high = res;
            while (low != high) {
                int mid = low + ((high - low) >> 1);
                if (tail[mid] <= x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            tail[low] = x;
            if (low == res) res++;
        }
        return res;
    }

    int LIS_COVER_EQUAL(int[] a) {
        int n = a.length, res = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] <= a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            int[] a = fs.readArray(n), b = fs.readArray(m);
            solve(n, m, a, b);
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
        new MergedLIS().run();
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

