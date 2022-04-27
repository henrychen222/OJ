/**
 * 03/27/22 morning
 * https://codeforces.com/contest/1658/problem/C
 */
package codeforce.cf.div2.r779;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1658/submission/151185791
    // reference: https://codeforces.com/blog/entry/101302
    void solve(int n, int[] c) {
        // tr(n, c);
        int one = Arrays.stream(c).filter(x -> x == 1).toArray().length;
        if (one != 1) {
            pr("NO");
            return;
        }
        // tr(c);
        int idx = indexOf(c, 1);
        int[] rot = rotate(c, idx);
        // tr(rot);
        for (int i = 1; i < n; i++) {
            if (rot[i] - rot[i - 1] > 1) {
                pr("NO");
                return;
            }
        }
        pr("YES");
    }

    int indexOf(int[] a, int x) {
        return IntStream.range(0, a.length).filter(i -> x == a[i]).findFirst().orElse(-1);
    }

    /////////////////////////////////////////
    // TLE don't know
    void solve1(int n, int[] c) {
//        int[] t = {5, 1, 2, 4, 6, 3};
//        tr(rotate(t, 5), preMax(t), power(t)); // first cyclic
        // tr(n, c);
        pr(test(n, c) ? "YES" : "NO");
    }

    boolean test(int n, int[] c) {
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i + 1;
        int[] rev = reverseA(p);
        if (canMake(p, c)) return true;
        while (!Arrays.equals(rev, p)) {
            next_permutation(p);
            if (canMake(p, c)) {
                // tr("ok permutation", p);
                return true;
            }
        }
        return false;
    }

    boolean canMake(int[] p, int[] c) {
        int n = p.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int[] rot = rotate(p, n - i);
            int power = power(rot);
            // tr("rot", rot, "p", power);
            res[i] = power;
        }
        // tr("power", res);
        return Arrays.equals(res, c);
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

    int power(int[] a) {
        int[] pre = preMax(a);
        // tr("rotate", a, "preMax", pre);
        Set<Integer> se = new HashSet<>();
        for (int x : pre) se.add(x);
        return se.size();
    }

    int[] preMax(int[] a) {
        int n = a.length, max = Integer.MIN_VALUE;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
            pre[i] = max;
        }
        return pre;
    }

    int[] rotate(int[] a, int cut) {
        int n = a.length;
        int[] l = Arrays.copyOfRange(a, 0, cut), r = Arrays.copyOfRange(a, cut, n);
        int[] res = concat(r, l);
        return res;
    }

    int[] concat(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] res = new int[n + m];
        int p = 0;
        for (int i = 0; i < n; i++) res[p++] = a[i];
        for (int i = 0; i < m; i++) res[p++] = b[i];
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] c = fs.readArray(n);
            solve(n, c);
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
        new C().run();
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