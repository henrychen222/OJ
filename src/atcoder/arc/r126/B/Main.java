/**
 * 09/19/21 morning
 * https://atcoder.jp/contests/arc126/tasks/arc126_b
 */
package atcoder.arc.r126.B;

import java.util.*;
import java.io.*;
import java.util.Map.Entry;

class Main {

    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/arc126/submissions/26002998 702ms
    // reference: https://atcoder.jp/contests/arc126/submissions/25985240
    void solve(int n, int m, int[][] ab) {
        Arrays.sort(ab, (x, y) -> {
            if (x[0] == y[0]) return y[1] - x[1];
            return x[0] - y[0];
        });
        Integer[] b = Arrays.stream(ab).map(x -> x[1]).toArray(Integer[]::new); // https://www.sitepoint.com/java-8-streams-filter-map-reduce/
//        int[] b = new int[m];
//        for (int i = 0; i < m; i++) b[i] = ab[i][1]; // Accepted -- https://atcoder.jp/contests/arc126/submissions/26003086 690ms
        List<Integer> res = new ArrayList<>();
        for (int x : b) {
            int idx = lower_bound2(res, x);
            if (idx == res.size()) {
                res.add(x);
            } else {
                res.set(idx, x);
            }
            // tr(res);
        }
        pr(res.size());
    }

    int lower_bound2(List<Integer> a, int x) { // Accepted --- https://atcoder.jp/contests/arc126/submissions/26003287 731ms
        int idx = Collections.binarySearch(a, x);
        if (idx < 0) {
            return -idx - 1;
        }
        return idx;
    }

    int lower_bound1(List<Integer> a, int x) {
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

    ///////////////////////////////////////////////////////////////////////////////////////////
    // WA 不是平行(斜率相等)才最多选取, 可以斜率从一个点从大到小递减
    void solve1(int n, int m, int[][] ab) {
        // tr(n, m, ab);
        Map<Double, Integer> ma = new HashMap<>();
        for (int[] e : ab) {
            double diff = e[1] - e[0] == 0 ? 0 : (double) 1 / (e[1] - e[0]);
            // tr(diff);
            ma.put(diff, ma.getOrDefault(diff, 0) + 1);
        }
        ma = sortMapByValue(ma);
        tr(ma);
        for (int v : ma.values()) {
            if (v <= m) {
                pr(v);
                return;
            }
        }
    }

    Map<Double, Integer> sortMapByValue(Map<Double, Integer> map) {
        List<Entry<Double, Integer>> data = new ArrayList<>(map.entrySet());
        Collections.sort(data, (a, b) -> b.getValue().compareTo(a.getValue()));
        Map<Double, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Entry<Double, Integer> entry : data) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int[][] ab = new int[m][2];
        for (int i = 0; i < m; i++) {
            ab[i][0] = fs.nextInt();
            ab[i][1] = fs.nextInt();
        }
        solve(n, m, ab);
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