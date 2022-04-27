/**
 * 02/11/22 moring
 * https://codeforces.com/problemset/problem/427/B
 */
package codeforce.global.r19;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1637/submission/146172670
    // reference: https://codeforces.com/blog/entry/99883
    void solve(int n, int[] a) {
        boolean allOne = true;
        long res = 0;
        for (int i = 1; i < n - 1; i++) {
            if (a[i] != 1) {
                allOne = false;
                break;
            }
        }
        if (allOne || (n == 3 && a[1] % 2 != 0)) {
            pr(-1);
            return;
        }
        for (int i = 1; i < n - 1; i++) res += a[i] % 2 == 0 ? a[i] / 2 : a[i] / 2 + 1;
        pr(res);
    }

    ///////////////////////////////////////////////////////////////////////////////
    // WA
    void solve2(int n, int[] a) {
        long step1 = 0, step2 = 0, one = 0;
        TreeMap<Integer, Integer> odd = new TreeMap<>(), even = new TreeMap<>();
        for (int i = 1; i < n - 1; i++) {
            if (a[i] % 2 == 0) {
                addOneOrManyMap(even, a[i]);
            } else {
                addOneOrManyMap(odd, a[i]);
            }
        }
        // tr(odd, even);
        if (odd.size() == 1 && even.size() == 0) {
            pr(-1);
            return;
        }
        while (odd.size() > 0) {
            int max = odd.lastKey();
            if (max == 1) {
                one++;
                removeOneOrManyMap(odd, 1);
            } else { // >= 3
                int min = odd.firstKey();
                removeOneOrManyMap(odd, min);
                addOneOrManyMap(even, min - 1); // issue
            }
            step1++;
        }
        long totEven = 0, sum = 0;
        for (int x : even.keySet()) {
            sum += (long) x * even.get(x);
            totEven += even.get(x);
        }
//        tr(odd, even);
//        tr("step1", step1, one, sum, totEven);
        if (totEven * 2 < one) {
            pr(-1);
            return;
        }
        if (one % 2 != 0) {
            one--;
            sum -= 2; // give to 1, drop
            step2++;
        }
        // tr(one, sum);
        sum -= one / 2;
        step2 += one / 2;
        step2 += sum / 2;
        // tr("step2", step2);
        pr(step1 + step2);
    }

    void addOneOrManyMap(TreeMap<Integer, Integer> m, int... a) {
        int x = a[0], cnt = a.length == 2 ? a[1] : 1;
        m.put(x, m.getOrDefault(x, 0) + cnt);
    }

    void removeOneOrManyMap(TreeMap<Integer, Integer> m, int... a) {
        int x = a[0], cnt = a.length == 2 ? a[1] : 1;
        int occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
        }
    }

    // WA
    void solve1(int n, int[] a) {
        long sum = 0, res = 0, one = 0;
        for (int i = 1; i < n - 1; i++) {
            sum += a[i];
            if (a[i] == 1) one++;
        }
        if (one >= 2 || (n == 3 && sum % 2 != 0)) {
            pr(-1);
            return;
        }
        if (sum % 2 != 0) {
            sum--;
            res++;
        }
        res += sum / 2;
        pr(res);
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

