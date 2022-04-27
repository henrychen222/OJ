/**
 * 03/27/22 morning
 * https://codeforces.com/contest/1658/problem/D1
 */
package codeforce.cf.div2.r779;

import java.util.*;
import java.io.*;

public class D1 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1658/submission/151188351
    // reference: tourist chinesedfan
    void solve(int l, int r, int[] a) {
        int n = a.length;
        int[] cnt = bitCount(30, a);
        // tr(cnt);
        long res = 0;
        for (int i = 0; i < 30; i++) {
            if (cnt[i] > n - cnt[i]) res |= 1 << i; // bit mask sum
        }
        pr(res);
    }

    int[] bitCount(int base, int[] a) {
        int[] cnt = new int[base];
        for (int i = 0; i < base; i++) {
            for (int x : a) {
                if ((x & (1 << i)) != 0) cnt[i]++;
            }
        }
        return cnt;
    }

    // Accepted --- https://codeforces.com/contest/1658/problem/D1
    // reference: https://codeforces.com/blog/entry/101302
    /*
     0 - 7
     000
     001
     010
     011
     100
     101
     110
     111

     xor features
     ith bit(i = 2)  [0,0,1,1,0,0,1,1]
     1's > 0's   ith bit = 1
     0's > 1's   ith bit = 0
     1's == 0's  ith bit = 0 or 1
     */
    void solve2(int l, int r, int[] a) {
        // tr(0 ^ 1, 0 ^ 0 ^ 1 ^ 1 ^ 0 ^ 0 ^ 1 ^ 1);
        int[][] cnt = new int[32][2];
        for (int x : a) {
            for (int i = 0; i <= 30; i++) {
                cnt[i][x % 2]++;
                x >>>= 1;
            }
        }
        long res = 0;
        for (int i = 0; i <= 30; i++) {
            if (cnt[i][0] < cnt[i][1]) res |= 1 << i;
        }
        pr(res);
    }

    //////////////////////////////////////////////
    // TLE don't know
    void solve1(int l, int r, int[] a) {
        // tr(l, r, a);
        int max = Arrays.stream(a).max().getAsInt();
        pr(test(a.length, max, a));
    }

    int test(int n, int max, int[] origin) {
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        int[] rev = reverseA(p);
        int x = findX(p, max, origin);
        if (x != -1) return x;
        while (!Arrays.equals(rev, p)) {
            next_permutation(p);
            x = findX(p, max, origin);
            if (x != -1) return x;
        }
        return -1;
    }

    int findX(int[] p, int max, int[] origin) {
        int n = p.length;
        for (int x = 0; x <= max; x++) {
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if ((p[i] ^ x) != origin[i]) {
                    ok = false;
                    break;
                }
            }
            // tr(x, ok, p);
            if (ok) return x;
        }
        return -1;
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

    int[] reverseA(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[n - i - 1];
        return b;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int l = fs.nextInt(), r = fs.nextInt();
            int[] a = fs.readArray(r - l + 1);
            solve(l, r, a);
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
        new D1().run();
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}