/**
 * 10/09/21 night
 * https://codeforces.com/contest/1598/problem/C
 */
package codeforce.ecf.r115;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/contest/1598/submission/131462287
// Accepted --- https://codeforces.com/contest/1598/submission/131462416 (first submisson is correct, long issue)
public class C {

    static PrintWriter pw;

    /**
     * 1 + 4 + 7 + 3 + 5 = 20/5 = 4
     * 4 + 3 + 5 = 12 / 3 = 4    1 + 7
     * 1 + 4 + 7 = 12 / 3 = 4    3 + 5
     */
    void solve(int n, int[] a) {
        // tr(n, a);
        // tr(20 % 2.5 == 0, 20 % 2.6 == 0);
        long sum = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) {
            sum += x;
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        double mean = (double) sum / n;
        // tr("mean", mean);
        long res = 0;
        Set<String> se = new HashSet<>();
        for (int x : m.keySet()) {
            double t = mean * 2;
            // if (sum % t != 0) continue;
            // if (!isInteger(t)) continue;
            double yy = t - x;
            double restMean = (sum - x - yy) / (n - 2);
            // tr("two sum", t, "restMean", restMean, x, yy);
            if (restMean != mean) continue;
            if (!isInteger(yy)) continue;
            int y = (int) yy;
            // tr("x y", x, y);
            int xocc = m.get(x);
            String ke;
            if (x <= y) {
                ke = x + " " + y;
            } else {
                ke = y + " " + x;
            }
            if (se.contains(ke)) continue;
            if (x == y) {
                if (xocc >= 2) {
                    // tr(x, y);
                    res += combination(xocc, 2);
                    se.add(ke);
                }
            } else {
                if (m.containsKey(y)) {
                    // tr(x, y);
                    int yocc = m.get(y);
                    res += (long) xocc * yocc; // fuck here, didn't cast long
                    se.add(ke);
                }
            }
        }
        pr(res);
    }

    boolean isInteger(double x) {
        return x == (int) x;
    }

    long combination(long m, long n) {
        return factorial(m, n) / factorial(n, n);
    }

    long factorial(long m, long n) {
        long num = 1;
        long cnt = 0;
        for (long i = m; i > 0; i--) {
            if (cnt == n) break;
            num *= i;
            cnt++;
        }
        return num;
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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
