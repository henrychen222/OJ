/**
 * 11/05/22 morning
 * https://atcoder.jp/contests/abc276/tasks/abc276_d
 */
package atcoder.abc.r276.D;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/abc276/submissions/36280369 (11/05/22 night)
    // reference: https://atcoder.jp/contests/abc276/submissions/36250222
    void solve(int n, int[] a) {
        int g = gcdArray(a), res = 0;
        for (int i = 0; i < n; i++) {
            a[i] /= g;
            while (a[i] % 2 == 0) {
                res++;
                a[i] /= 2;
            }
            while (a[i] % 3 == 0) {
                res++;
                a[i] /= 3;
            }
            if (a[i] != 1) {
                pr(-1);
                return;
            }
        }
        pr(res);
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    int gcdArray(int[] a) {
        int res = 0;
        for (int x : a) {
            res = gcd(res, x);
            if (res == 1) {
                return 1;
            }
        }
        return res;
    }

    // WA
    void solve1(int n, int[] a) {
        TreeMap<Integer, Integer> m = counter(a);
        long res = 0;
        while (true) {
            // tr(m, res);
            if (m.size() == 1) {
                pr(res);
                return;
            }
            int max = m.lastKey();
            removeOneOrManyMap(m, max);
            if (max % 2 == 0) {
                if (max % 3 == 0) {
                    max /= 6;
                    res += 2;
                } else {
                    max /= 2;
                    res++;
                }
            } else {
                if (max % 3 == 0) {
                    max /= 3;
                    res++;
                } else {
                    pr(-1);
                    return;
                }
            }
            addOneOrManyMap(m, max);
        }
    }

    <T> void addOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.put(x, m.getOrDefault(x, 0) + cnt);
    }

    <T> void removeOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0], occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
        }
    }

    TreeMap<Integer, Integer> counter(int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
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