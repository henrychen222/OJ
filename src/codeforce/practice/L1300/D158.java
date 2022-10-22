/**
 * 09/09/22 night
 * https://codeforces.com/problemset/problem/158/D
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class D158 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/158/171572330
    // reference: natsugiri + neal
    void solve(int n, int[] a) {
        TreeSet<Integer> factors = findAllFactors(n);
        long res = Long.MIN_VALUE;
        for (int f : factors) {
            if (f < 3) continue;
            int jump = n / f;
            for (int i = 0; i < jump; i++) {
                long sum = 0;
                for (int j = 0; j < n; j += jump) sum += a[i + j];
                res = Math.max(res, sum);
            }
        }
        pr(res);
    }

    // WA
    void solve1(int n, int[] a) {
        TreeSet<Integer> f = findAllFactors(n);
        List<Integer> neg = new ArrayList<>(), use = new ArrayList<>();
        for (int x : a) {
            if (x < 0) {
                neg.add(x);
            } else {
                use.add(x);
            }
        }
        Collections.sort(neg);
        Collections.sort(use);
        long res = Long.MIN_VALUE;
        for (int x : f) {
            if (x >= 3) {
                long v = work(x, neg, use);
                tr("f", x, "sum", v);
                res = Math.max(res, v);
            }
        }
        pr(res);
    }

    long work(int tot, List<Integer> neg, List<Integer> use) {
        long res = 0;
        for (int x : use) res += x;
        if (use.size() <= tot) { // 不够从最大开始加
            int need = tot - use.size();
            int p = neg.size() - 1;
            while (need-- > 0) res += neg.get(p--);
        } else { // 多了从最小的开始移除
            int toRemove = use.size() - tot;
            int p = 0;
            while (toRemove-- > 0) res -= use.get(p++);
        }
        return res;
    }

    TreeSet<Integer> findAllFactors(int n) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    res.add(i);
                } else {
                    res.add(i);
                    res.add(n / i);
                }
            }
        }
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
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
        new D158().run();
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