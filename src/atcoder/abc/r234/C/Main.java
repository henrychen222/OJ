/**
 * 01/08/22 morning
 * https://atcoder.jp/contests/abc234/tasks/abc234_c
 */
package atcoder.abc.r234.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/abc234/submissions/28418290
    // reference: https://atcoder.jp/contests/abc234/submissions/28383438
    void solve(long k) {
        String s = "";
        while (k > 0) {
            s += k % 2 == 0 ? "0" : "2";
            k /= 2;
        }
        pr(reverse(s));
    }

    String reverse(String s) {
        int n = s.length();
        String res = "";
        for (int i = n - 1; i >= 0; i--) res += s.charAt(i);
        return res;
    }
    //////////////////////////////////////////////////////////////////////////
    /*
      2
      20 22             2 ^ 1
      200 202 220 222   2 ^ 2
      2000 2002 2020 2022 2200 2202 2220 2222     2 ^ 3 = 8
     */
    // TLE https://atcoder.jp/contests/abc234/submissions/28417094
    void solve1(long k) {
        if (k == 1) {
            pr(2);
            return;
        }
        int len = 2;
        long sum = 1;
        while (true) {
            long add = (long) Math.pow(2, len - 1);
            if (sum + add >= k) break;
            sum += add;
            len++;
            // tr(len, sum, add);
        }
        long rest = k - sum;
//        tr(len, rest);
        char[] res = new char[len];
        Arrays.fill(res, '0');
        res[0] = '2';
        TreeSet<String> ts = new TreeSet<>(new Inc());
        ts.add(new String(res));
        dfs(res, 1, len, ts, rest);
        int cnt = 1;
        for (String s : ts) {
            if (cnt == rest) {
                pr(s);
                return;
            }
            cnt++;
        }
    }

    void dfs(char[] a, int idx, int len, TreeSet<String> ts, long rest) {
        // tr(a, ts, ts.size(), rest);
//        if (ts.size() == rest) {
//            pr(ts.last());
//            return;
//        }
        for (int i = idx; i < len; i++) {
            a[i] = '2';
            ts.add(new String(a));
            dfs(a, idx + 1, len, ts, rest);
            a[i] = '0';
        }
    }

    class Inc implements Comparator<String> {
        public int compare(String x, String y) {
            int xn = x.length(), yn = y.length();
            if (xn != yn) return xn - yn;
            for (int i = 0; i < xn; i++) {
                char cx = x.charAt(i), cy = y.charAt(i);
                if (cx != cy) return (cx - '0') - (cy - '0');
            }
            return 0;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        solve(fs.nextLong());
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