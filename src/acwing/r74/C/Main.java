/**
 * 10/22/22 morning
 * https://www.acwing.com/problem/content/4712/
 */
package acwing.r74.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    /*
     reference: https://www.acwing.com/solution/content/144213/
     */
    void solve(int n, int[] a) {
        Fenwick fen = new Fenwick(n + 3);
        int[] u = removeDuplicatedSorted(a);
//        tr('a', a);
//        tr('u', u);
        long[] L = new long[n], R = new long[n];
        for (int i = 0; i < n; i++) a[i] = lower_bound(u, a[i]) + 1;
        for (int i = 0; i < n; i++) {
            L[i] = i - fen.query(a[i]);
            fen.update(a[i], 1);
        }
        fen.reset();
        for (int i = n - 1; i >= 0; i--) {
            R[i] = fen.query(a[i] - 1);
            fen.update(a[i], 1);
        }
        // tr(L, R);
        long res = 0;
        for (int i = 0; i < n; i++) res += L[i] * R[i];
        pr(res);
    }

    class Fenwick {
        int n;
        int[] a;

        Fenwick(int n) {
            this.n = n;
            // n = n; // issue
            a = new int[n];
        }

        long query(int i) {
            long sum = 0;
            for (i++; i > 0; i = parent(i)) sum += a[i];
            return sum;
        }

        void update(int i, int v) {
            for (i++; i < n; i = next(i)) a[i] += v;
        }

        int parent(int x) {
            return x - lowestOneBit(x);
        }

        int next(int x) {
            return x + lowestOneBit(x);
        }

        int lowestOneBit(int x) {
            return x & -x;
        }

        void reset() {
            Arrays.fill(a, 0);
        }
    }

    int lower_bound(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + high >>> 1;
            if (a[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    int[] removeDuplicatedSorted(int[] a) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : a) ts.add(x);
        int[] res = new int[ts.size()];
        int p = 0;
        for (int x : ts) res[p++] = x;
        return res;
    }

    ////////////////////////////////////////////////////////////////////////////
    // WA 选取三个数是subsequence, 不是subarray
    void solve1(int n, int[] a) {
        List<int[]> d = cutMaxConsecutive_dec(a);
        debugArrayInList(d);
        long res = 0;
        for (int[] e : d) res += combination(e.length, 3);
        pr(res);
    }

    long combination(long m, long n) {
        return factorial(m, n) / factorial(n, n);
    }

    long factorial(long m, long n) {
        long res = 1, cnt = 0;
        for (long x = m; x > 0; x--) {
            if (cnt == n) break;
            res *= x;
            cnt++;
        }
        return res;
    }

    List<int[]> cutMaxConsecutive_dec(int[] a) {
        List<int[]> d = new ArrayList<>();
        int start = 0, n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i] <= a[i + 1]) {
                d.add(Arrays.copyOfRange(a, start, i + 1));
                start = i + 1;
            }
        }
        d.add(Arrays.copyOfRange(a, start, n));
        return d;
    }

    void debugArrayInList(List<int[]> l) {
        int[][] res = new int[l.size()][];
        for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
        tr("out", res);
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