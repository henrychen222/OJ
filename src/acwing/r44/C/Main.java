/**
 * 03/26/22 morning
 * https://www.acwing.com/problem/content/4322/
 */
package acwing.r44.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;
    private final int N = 100005;
    int[] f;

    // Accepted  04/26/22 evening
    // reference: https://www.acwing.com/solution/content/105278/
    void solve(int n, int k, int[] a) {
        // test(n, k, a);
        long res = 0;
        for (int x : a) {
            int cur = x;
            long p = 1, comP = 1;
            for (int i = 2; i * i <= x; i++) { //先分解因式
                if (cur % i == 0) { //i是x的因子
                    int cnt = 0; //i的阶数
                    while (cur % i == 0) {
                        cnt++;
                        cur /= i;
                    }
                    cnt %= k;
                    if (cnt > 0) {
                        p *= power(i, cnt);
                        comP *= power(i, k - cnt);
                    }
                }
            }
            // tr("cur", cur, "p", p, "comP", comP);
            if (cur > 1) {  //因式分解后还是大于1 说明是质数
                p *= cur;
                comP *= power(cur, k - 1);
            }
            if (comP >= N) comP = 0;
            res += f[(int) comP];
            f[(int) p]++;
        }
        pr(res);
    }

    long power(int x, int cnt) {
        long res = 1;
        while (cnt-- > 0) {
            res *= x;
            if (res >= N) {
                res = 0;
                break;
            }
        }
        return res;
    }

    //////////////////////////////////////////////////////////////////////////
    // TLE 7/15 pass
    void test(int n, int k, int[] a) {
        long res = 0;
        for (int l = 0; l < n; l++) {
            for (int r = l + 1; r < n; r++) {
                long mul = (long) a[l] * a[r];
                // tr(a[l], a[r], mul);
                if (ok(mul, k)) res++;
            }
        }
        pr(res);
    }

    /*
     x ^ k = mul
     (x ^ k) ^ (2 / k) = mul ^ (2 / k)
      x ^ 2 = mul ^ (2 / k)
     */
    boolean ok1(int mul, int k) {
        // if (2 % k != 0) return false;
        double t = Math.pow(mul, 2 / k);
        double x = Math.sqrt(t);
        tr("x", x, "mul", mul, 't', t);
        return isInteger(x);
    }

    boolean ok(long mul, int k) {
        for (int x = 1; ; x++) {
            double v = Math.pow(x, k);
            if (Math.pow(x, k) == mul) {
                // tr(mul, x, k);
                return true;
            }
            if (v > mul) break;
        }
        return false;
    }

    boolean isInteger(double x) {
        return x == (int) x;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        f = new int[N];
        int n = fs.nextInt(), k = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, k, a);
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