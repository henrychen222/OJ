/**
 * 06/04/22 morning
 * https://atcoder.jp/contests/abc254/tasks/abc254_d
 */
package atcoder.abc.r254.D;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;
    long MAX = 200000L * 200000L;
    List<Long> a;

    // Accepted --- https://atcoder.jp/contests/abc254/submissions/32247859
    // reference: https://atcoder.jp/contests/abc254/submissions/32210325
    void solve(int n) {
        Map<TreeSet<Integer>, Integer> m = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            TreeSet<Integer> f = factor(i);
            m.put(f, m.getOrDefault(f, 0) + 1);
        }
        // tr(m);
        long res = 0;
        for (int occ : m.values()) res += (long) occ * occ;
        pr(res);
    }

    TreeSet<Integer> factor(int n) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                int cnt = 0;
                while (n % i == 0) {
                    n /= i;
                    ++cnt;
                }
                if (cnt % 2 != 0) res.add(i);
            }
        }
        if (n > 1) res.add(n);
        return res;
    }

    ////////////////////////////////////////////////////////////
    // TLE
    void solve1(int n) {
        test(n);
        for (long i = 1; i * i <= MAX; i++) a.add(i * i);
        // tr(a.size());
        long res = 0;
        for (int i = 1; i <= n; i++) {
            long min = i, max = (long) n * i;
            int sqBeginIndex = lower_bound(a, min); // >=
            int sqEndIndex = upper_bound(a, max) - 1; // <=
//            long sqBegin = a.get(sqBeginIndex), sqEnd = a.get(sqEndIndex);
//            tr(sqBegin, sqEnd);
            long cnt = 0;
            for (int j = sqBeginIndex; j <= sqEndIndex; j++) {
                if (a.get(j) % i == 0) cnt++;
            }
            // tr("i", i, "j", "cnt", cnt);
            res += cnt;
        }
        pr(res);
    }

    void test(int n) {
        long res = 0;
        for (int i = 1; i <= n; i++) {
            long cnt = 0;
            for (int j = 1; j <= n; j++) {
                long x = (long) i * j;
                double sq = Math.sqrt(x);
                if (isInteger(sq)) {
                    // tr(i, j, "x", x, sq);
                    cnt++;
                }
            }
            // tr("i", i, "cnt", cnt);
            res += cnt;
        }
        pr(res);
    }

    boolean isInteger(double x) {
        return x == (int) x;
    }

    int lower_bound(List<Long> a, long x) {
        int low = 0, high = a.size();
        while (low < high) {
            int mid = low + high >>> 1;
            if (a.get(mid) < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    int upper_bound(List<Long> a, long x) {
        int low = 0, high = a.size();
        while (low < high) {
            int mid = low + high >>> 1;
            if (x < a.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        a = new ArrayList<>();
        int n = fs.nextInt();
        solve(n);
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