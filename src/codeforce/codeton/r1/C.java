/**
 * 03/24/22 morning
 * https://codeforces.com/contest/1656/problem/C
 */
package codeforce.codeton.r1;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1656/submission/150825093
    // reference: Tlatoani SecondThread
    void solve(int n, int[] a) {
        Arrays.sort(a);
        boolean hasOne = false, hasAdjacent = false;
        for (int x : a) {
            if (x == 1) {
                hasOne = true;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if (a[i] - a[i - 1] == 1) {
                hasAdjacent = true;
                break;
            }
        }
        // 两数差1, mod后大数变为1
        pr(hasOne && hasAdjacent ? "NO" : "YES");
    }

    /////////////////////////////////////////////////////
    /*
     [2 5 6 8]
     [2 5 6 1]  7
     [2 0 1 1]  5
     [0 0 1 1]  2
     [0 0 0 0]  1

     [4 1 7 0 8]
     [4 1 0 0 1]  7
     [1 1 0 0 1]  3
     [0 0 0 0 0]  1
     */
    // WA
    void solve2(int n, int[] a) {
        TreeMap<Integer, Integer> m = counter(a);
        // for (int i= 0; i < 5; i++) {
        while (m.size() > 1) {
            int max = m.lastKey();
            boolean ok = false;
            if (max >= 2) {
                ok = true;
                addOneOrManyMap(m, 0, m.get(max));
                m.remove(max);
            }
            if (!ok) break;
        }
        tr(m);
        pr(m.size() == 1 ? "YES" : "NO");
    }

    void addOneOrManyMap(TreeMap<Integer, Integer> m, int... a) {
        int x = a[0], cnt = a.length == 2 ? a[1] : 1;
        m.put(x, m.getOrDefault(x, 0) + cnt);
    }

    TreeMap<Integer, Integer> counter(int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    // WA
    void solve1(int n, int[] a) {
        if (n == 1) {
            pr("YES");
            return;
        }
        long lcm = LCMArray(a);
        tr(a, lcm);
        pr(lcm == 0 ? "NO" : "YES");
    }

    long LCMArray(int[] a) {
        int n = a.length;
        long lcm = lcm(a[0], a[1]);
        for (int i = 2; i < n; i++) {
            lcm = lcm(lcm, a[i]);
        }
        return lcm;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return a / gcd(a, b) * b;
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