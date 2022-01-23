/**
 * 01/19/22 morning
 * https://www.codechef.com/START22C/problems/EQLIS
 */
package codechef.contest.start.c_22;

import java.util.*;
import java.io.*;

class EqualLIS {
    static PrintWriter pw;

    /*
     [2, 1, 3, 8, 7, 6, 4, 5]
     */
    // Accepted --- https://www.codechef.com/viewsolution/56733682
    /*
      WA: only one case
      https://www.codechef.com/viewsolution/56719255 (n == 4 yes wrong array)
      https://www.codechef.com/viewsolution/56722916 (n == 4 no)
      https://www.codechef.com/viewsolution/56728500 (n == 4 no)
     */
    void solve(int n) {
        if (n == 2) {
            pr("NO");
            return;
        } else if (n == 4) { // fuck issue, 4 is YES, not NO
            int[] a = new int[]{1, 2, 3, 4};
            while (true) {
                if (LIS(a) == LIS(reverseA(a))) {
                    pr("YES");
                    outputA(a);
                    return;
                } else {
                    next_permutation(a);
                }
            }
        }
        int[] a;
        if (n % 2 == 0) {
            a = new int[n];
            int m = n / 2;
            for (int i = 0; i <= m - 2; i++) a[i] = i + 1;
            swap(a, 0, 1);
            for (int i = n - 1, x = m; i > m - 2; i--, x++) a[i] = x;
            swap(a, n - 2, n - 1);
        } else {
            a = new int[n];
            int m = n / 2;
            a[n - 1] = m + 1;
            for (int i = 0; i < m; i++) a[i] = i + 1;
            for (int i = n - 2, x = m + 2; i >= m; i--, x++) a[i] = x;
        }
        // tr(LIS(a), LIS(reverseA(a)));
        pr("YES");
        outputA(a);
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

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    int[] reverseA(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[n - i - 1];
        return b;
    }

    int LIS(int[] a) {
        int n = a.length, res = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
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
            int n = fs.nextInt();
            solve(n);
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
        new EqualLIS().run();
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