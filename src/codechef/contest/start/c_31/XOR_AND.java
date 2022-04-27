/**
 * 03/23/22 morning
 * https://www.codechef.com/START31C/problems/XORAND
 */
package codechef.contest.start.c_31;

import java.util.*;
import java.io.*;

class XOR_AND {
    static PrintWriter pw;

    /**
     * Accepted --- https://www.codechef.com/viewsolution/61194876
     * reference:
     * https://discuss.codechef.com/t/xorand-editorial/100151
     * http://p.ip.fi/SwDF
     */
    void solve(int n, int[] a) {
        int[] cnt = new int[32];
        for (int x : a) cnt[Integer.numberOfLeadingZeros(x)]++;
        long res = 0;
        for (int i = 0; i < 32; i++) res += (long) cnt[i] * (cnt[i] - 1) / 2;
        pr(res);
    }

    ///////////////////////////////////////////////////////

    /**
     * TLE
     * https://www.codechef.com/viewsolution/61185787
     * https://www.codechef.com/viewsolution/61187354
     * https://www.codechef.com/viewsolution/61189555
     * <p>
     * https://www.codechef.com/viewsolution/61191418
     * https://www.codechef.com/viewsolution/61193125
     */
    /*
     31  [16, 31]
     32, 45, 46, 63  [32, 63]
     64  [64, 127]
     */
    void solve1(int n, int[] a) {
//        tr(range(45), range(32), range(64));
//        for (int x = 1; x <= 130; x++) {
//            int xor = 64 ^ x, and = 64 & x;
//            tr("x", x, "xor", xor, "and", and, xor < and);
//        }
        long res = 0;
        int[] u = removeDuplicatedSorted(a);
        TreeMap<Long, ArrayList<Integer>> m = counter_value_in_indexA_in(a);
        for (int i = 0; i < n; i++) {
            long[] range = range(a[i]);
//            for (int x : m.keySet()) {
//                if (x >= range[0] && x <= range[1]) {
//                    List<Integer> l = m.get(x);
//                    int j = upper_bound(l, i);
//                    res += l.size() - j;
//                }
//            }

//            long min = m.ceilingKey(range[0]); // >=
//            long max = m.floorKey(range[1]); // <=
//            for (long x = min; x <= max; x++) {
//                if (m.containsKey(x)) {
//                    List<Integer> l = m.get(x);
//                    int j = upper_bound(l, i);
//                    res += l.size() - j;
//                }
//            }
            int L = lower_bound(u, range[0]), R = upper_bound(u, range[1]) - 1;
            for (int idx = L; idx <= R; idx++) {
                long v = u[idx];
                if (m.containsKey(v)) {
                    List<Integer> list = m.get(v);
                    int j = upper_bound(list, i);
                    res += list.size() - j;
                }
            }
        }
        pr(res);
    }

    int upper_bound(List<Integer> a, int x) {
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

    long[] range(int x) {
        int l = (int) Math.floor(Math.log10(x) / Math.log10(2)), r = l + 1;
        return new long[]{1L << l, (1L << r) - 1};
    }

    TreeMap<Long, ArrayList<Integer>> counter_value_in_indexA_in(int[] a) {
        TreeMap<Long, ArrayList<Integer>> m = new TreeMap<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            long v = a[i];
            if (!m.containsKey(v)) m.put(v, new ArrayList<>());
            m.get(v).add(i);
        }
        return m;
    }

    int[] removeDuplicatedSorted(int[] a) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : a) ts.add(x);
        int[] res = new int[ts.size()];
        int p = 0;
        for (int x : ts) res[p++] = x;
        return res;
    }

    int lower_bound(int[] a, long x) {
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

    int upper_bound(int[] a, long x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + high >>> 1;
            if (x < a[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    void test(int[] a) {
        int n = a.length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xor = a[i] ^ a[j], and = a[i] & a[j];
                tr("i", i + 1, "j", j + 1, "a[i]", a[i], "a[j]", a[j], "xor", xor, "and", and);
                if (xor < and) {
                    tr("ok", "a[i]", a[i], "a[j]", a[j]);
                    res++;
                }
            }
        }
        tr(res);
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
        new XOR_AND().run();
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
