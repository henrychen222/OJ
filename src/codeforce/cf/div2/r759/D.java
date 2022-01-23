/**
 * 12/12/21 morning
 * https://codeforces.com/contest/1591/problem/D
 */
package codeforce.cf.div2.r759;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1591/submission/138980449  (12/13/21 morning)
    // reference: wifi
    void solve(int n, int[] a) {
        Set<Integer> as = new HashSet<>();
        for (int x : a) as.add(x);
        boolean res = reversePair(a) % 2 == 0 || as.size() != n;
        pr(res ? "YES" : "NO");
    }

    long reversePair(int[] a) { // Read LC493 https://leetcode.com/problems/reverse-pairs/
        // tr(a);
        int n = a.length;
        int[] b = Arrays.copyOf(a, n);
        b = removeArrayDuplicates(b);
        Arrays.sort(b);
        Fenwick ft = new Fenwick(b.length);
        // tr(b);
        long res = 0;
        for (int i = 0; i < n; i++) {
            int idx = lower_bound(b, a[i]);
            long query = ft.query(idx);
            // tr("idx", idx, "res", res, "query", query);
            res += i - query;
            ft.update(idx, 1);
        }
        return res;
    }

    int[] removeArrayDuplicates(int[] a) {
        Set<Integer> se = new HashSet<>();
        // tr("before", a);
        for (int x : a) se.add(x);
        // tr("set", se); // different order
        int n = se.size();
        int[] res = new int[n];
        int i = 0;
        for (int x : se) {
            res[i] = x;
            i++;
        }
        // tr("after", res);
        return res;
    }

    // Accepted --- https://codeforces.com/contest/1591/submission/138981186
    int lower_bound2(int[] a, int x) {
        int idx = Arrays.binarySearch(a, x);
        if (idx < 0) {
            return -idx - 1;
        }
        return idx;
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

    class Fenwick {
        int n;
        int[] tree;

        Fenwick(int n) {
            this.n = n;
            this.tree = new int[n];
        }

        long query(int i) {
            i = Math.min(i + 1, n);
            // tr("tree", tree, "start", i);
            long sum = 0;
            while (i > 0) {
                sum += this.tree[i - 1];
                i -= i & -i;
            }
            return sum;
        }

        void update(int i, int v) {
            assert i >= 0 && i < n;
            i++;
            while (i <= n) {
                this.tree[i - 1] += v;
                i += i & -i;
            }
        }
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
        new D().run();
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