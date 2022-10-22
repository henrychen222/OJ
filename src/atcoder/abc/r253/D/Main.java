/**
 * 05/28/22 morning
 * https://atcoder.jp/contests/abc253/tasks/abc253_d
 */
package atcoder.abc.r253.D;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;
    int n, a, b;

    /*
      WA --- https://atcoder.jp/contests/abc253/submissions/32052847
      Accepted --- https://atcoder.jp/contests/abc253/submissions/32100243
     */
    void solve() {
        // long c = (long) a * b;  wrong here
        long c = lcm(a, b);
        long maxA = maxMultiple(a), maxB = maxMultiple(b), maxC = maxMultiple(c);
        // tr(maxA, maxB);
        long sumA = SumOfRangeDis(a, maxA, a), sumB = SumOfRangeDis(b, maxB, b), sumBoth = SumOfRangeDis(c, maxC, c);
        long sum = sumA + sumB - sumBoth;
        // tr(sumA, sumB, "sumBoth", sumBoth, "sum", sum);
        long tot = (long) (1 + n) * n / 2;
        pr(tot - sum);
    }

    long maxMultiple(long x) {
        long N = n;
        return N - N % x;
    }

    long SumOfRangeDis(long start, long end, long dis) {
        long cnt = (end - start) / dis + 1;
        return (start + end) * cnt / 2;
    }

    long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return a / gcd(a, b) * b;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // TLE
    void solve2() {
        long tot = (long) (1 + n) * n / 2;
        long sum = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = a, t = 2; i <= n; i = a * t, t++) {
            if (ok(i)) {
                sum += i;
                used.add(i);
            }
        }
        for (int i = b, t = 2; i <= n; i = b * t, t++) {
            if (ok(i) && !used.contains(i)) {
                sum += i;
            }
        }
        pr(tot - sum);
    }

    void solve1() {
        TreeSet<String> res = new TreeSet<>();
        dfs("", res);
        tr(res);
        long tot = (long) (1 + n) * n / 2;
        long sum = 0;
        for (String s : res) sum += Integer.parseInt(s);
        tr(tot, sum);
        pr(tot - sum);
    }

    void dfs(String cur, TreeSet<String> res) {
        // tr("cur", cur, "res", res);
        char start = cur.length() == 0 ? '1' : '0';
        for (char i = start; i <= '9'; i++) {
            cur += i;
            long x = Long.parseLong(cur);
            if (x >= 1 && x <= n) {
                if (ok((int) x)) res.add(cur);
                dfs(cur, res);
            }
            cur = cur.substring(0, cur.length() - 1);
        }
    }

    boolean ok(int x) {
        return x % a == 0 || x % b == 0;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        n = fs.nextInt();
        a = fs.nextInt();
        b = fs.nextInt();
        solve();
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