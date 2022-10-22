/**
 * 10/19/22 evening get stuck
 * 10/21/22 night complete
 * https://codeforces.com/problemset/problem/39/B
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B39 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/39/177426683
    void solve(int n, int[] a) {
//        int m = (int) Arrays.stream(a).filter(x -> x > 0).count();
//        int[][] b = new int[m][];
//        int p = 0;
//        for (int i = 0; i < n; i++) {
//            if (a[i] > 0) b[p++] = new int[]{a[i], i};
//        }
//        Arrays.sort(b, (x, y) -> x[0] - y[0]);

        TreeMap<Integer, ArrayList<Integer>> m = counter_value_in_indexA_in(a);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) { // subsequence needs start from 1
                List<Integer> pick = new ArrayList<>();
                pick.add(i);
                res.add(pick);
            }
        }
        for (List<Integer> pick : res) {
            // tr("pick", pick);
            while (true) {
                int preIdx = pick.get(pick.size() - 1), preV = a[preIdx], nextV = preV + 1;
                // tr("preIdx", preIdx, "preV", preV, "nextV", nextV);
                if (m.containsKey(nextV)) {
                    int nextIdx = -1;
                    for (int j : m.get(nextV)) {
                        if (j > preIdx) { // greedy, subsequence picking next index: get as small as possible for make longest
                            nextIdx = j;
                            break;
                        }
                    }
                    if (nextIdx == -1) {
                        break;
                    } else {
                        pick.add(nextIdx);
                    }
                } else {
                    break;
                }
            }
        }
        if (res.size() == 0) {
            pr(0);
            return;
        }
        Collections.sort(res, (x, y) -> y.size() - x.size());
        List<Integer> longest = res.get(0);
        pr(longest.size());
        outputL(longest);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print((e + 2001) + " ");
        pr("");
    }

    TreeMap<Integer, ArrayList<Integer>> counter_value_in_indexA_in(int[] a) {
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!m.containsKey(a[i])) m.put(a[i], new ArrayList<>());
            m.get(a[i]).add(i);
        }
        return m;
    }

    int LIS_FAST(int[] a) {
        List<Integer> dp = new ArrayList<>();
        for (int x : a) {
            int i = lower_bound(dp, x);
            if (dp.size() == 0 || dp.get(dp.size() - 1) < x) {
                dp.add(x);
            } else {
                dp.set(i, x);
            }
        }
        return dp.size();
    }

    int lower_bound(List<Integer> a, int x) {
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
        new B39().run();
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