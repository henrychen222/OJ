/**
 * 03/12/22 morning
 * https://atcoder.jp/contests/abc243/tasks/abc243_c
 */
package atcoder.abc.r243.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // WA TLE
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        Map<Integer, List<int[]>> L = new HashMap<>();
        Map<Integer, List<int[]>> R = new HashMap<>();
        int[][] points = new int[n][];
        for (int i = 0; i < n; i++) points[i] = fs.readArray(2);
        char[] s = fs.next().toCharArray();
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if (s[i] == 'L') {
                if (!L.containsKey(y)) L.put(y, new ArrayList<>());
                L.get(y).add(new int[]{x, i + 1});
            } else {
                if (!R.containsKey(y)) R.put(y, new ArrayList<>());
                R.get(y).add(new int[]{x, i + 1});
            }
        }
//        debugMapWithValueArrayInList('l', L);
//        debugMapWithValueArrayInList('r', R);
        if (L.size() == 0 || R.size() == 0) {
            pr("No");
            return;
        }
        for (int yl : L.keySet()) {
            List<int[]> al = L.get(yl);
            for (int[] el : al) {
                int xl = el[0];
                for (int yr : R.keySet()) {
                    List<int[]> rl = R.get(yr);
                    for (int[] er : rl) {
                        int xr = er[0];
                        if (xl > xr) {
                            pr("Yes");
                            return;
                        }
                    }
                }
            }
        }
        pr("No");
    }

    void debugMapWithValueArrayInList(char c, Map<Integer, List<int[]>> m) {
        Map<Integer, List<List<Integer>>> res = new HashMap<>();
        for (int x : m.keySet()) {
            List<int[]> l = m.get(x);
            List<List<Integer>> transform = new ArrayList<>();
            for (int[] a : l) {
                List<Integer> t = new ArrayList<>();
                t.add(a[0]);
                t.add(a[1]);
                transform.add(t);
            }
            res.put(x, transform);
        }
        if (c == 'l') {
            tr("L", res);
        } else {
            tr("R", res);
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