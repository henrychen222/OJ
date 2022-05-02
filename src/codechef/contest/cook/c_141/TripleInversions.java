/**
 * 05/01/22 morning
 * https://www.codechef.com/COOK141C/problems/TRIPLE_INVS
 */
package codechef.contest.cook.c_141;

import java.util.*;
import java.io.*;

class TripleInversions {
    static PrintWriter pw;

    /*
      reference:
      https://www.codechef.com/viewsolution/63986427
      https://www.codechef.com/viewsolution/63985674
      https://discuss.codechef.com/t/triple-invs-editorial/100886

      Accepted --- https://www.codechef.com/viewsolution/64061849 (050122 evening)
     */
    void solve(int n, int[] a) {
        for (int start = 0; start < 2; start++) {
            int cur = start;
            boolean ok = true;
            for (int x : a) {
                if (x < cur) {
                    ok = false;
                    break;
                }
                x -= cur;
                if (x == 0) {
                    cur = 0;
                } else if (x == 1) {
                    cur = 1 - cur;
                } else if (x == 2) {
                    cur = 1;
                } else {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                pr("YES");
                return;
            }
        }
        pr("NO");
    }

    // TLE
    void solve1(int n, int[] a) {
        int[] p = new int[n + 2];
        for (int i = 0; i < n + 2; i++) p[i] = i + 1;
        if (Arrays.equals(test(p), a)) {
            pr("YES");
            return;
        }
        do {
            int[] inv = test(p);
            // tr(p, "inversion", inv);
            if (Arrays.equals(inv, a)) {
                pr("YES");
                return;
            }
        } while (next_permutation(p));
        pr("NO");
    }

    int[] test(int[] p) {
        int n = p.length;
        int[] res = new int[n - 2];
        for (int i = 0; i + 2 < n; i++) {
            int[] sub = Arrays.copyOfRange(p, i, i + 3);
            res[i] = inversion(sub);
        }
        return res;
    }

    int inversion(int[] a) { // a.length == 3
        int cnt = 0;
        if (a[0] > a[1]) cnt++;
        if (a[0] > a[2]) cnt++;
        if (a[1] > a[2]) cnt++;
        return cnt;
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
        new TripleInversions().run();
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}