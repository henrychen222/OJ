/**
 * 01/15/23 morning
 * https://codeforces.com/problemset/problem/6/E
 */
package codeforce.practice.L1900;

import java.util.*;
import java.io.*;

// Use TreeSet with Pairs === TreeMap (save all values cover duplicates), single TreeSet is wrong
public class E6 {
    static PrintWriter pw;

    /*
    7 0
    14 12 10 12 12 11 11
    problem is the duplicates
     */
    // WA --- https://codeforces.com/contest/6/submission/189342192 (need to use Pair to make every element is different)
    void solve(int n, int k, int[] h) {
        int max = 1;
        TreeSet<Integer> ts = new TreeSet<>();
        List<int[]> res = new ArrayList<>();
        ts.add(h[0]);
        int r = 0;
        for (int i = 0; i < n; ) {
            // tr(i, r);
            while (r < n) {
                r++;
                if (r >= n) break;
                ts.add(h[r]);
                if (ts.last() - ts.first() > k) break;
            }
            if (max < r - i) {
                max = r - i;
                res = new ArrayList<>();
                res.add(new int[]{i + 1, r});
                // res.add((i + 1) + " " + r);
            } else if (max == r - i) {
                res.add(new int[]{i + 1, r});
                // res.add((i + 1) + " " + r);
            }
            // tr("res", res);
            max = Math.max(max, r - i);
            ts.remove(h[i++]);
            while (ts.size() > 0 && ts.last() - ts.first() > k) ts.remove(h[i++]);
        }
        // tr("res", res);
        pr(max + " " + res.size());
//        for (String e : res) pr(e);
        for (int[] e : res) pr(e[0] + " " + e[1]);
    }


    // Accepted --- https://codeforces.com/contest/6/submission/189344280
    void solve2(int n, int k, int[] h) {
        int max = 1;
        TreeSet<Pair> ts = new TreeSet<>();
        List<String> res = new ArrayList<>();
        ts.add(new Pair(h[0], 0));
        int r = 0;
        for (int i = 0; i < n; ) {
            // tr(i, r);
            while (r < n) {
                r++;
                if (r >= n) break;
                ts.add(new Pair(h[r], r));
                if (ts.last().first - ts.first().first > k) break;
            }
            if (max < r - i) {
                max = r - i;
                res.clear();
                res.add((i + 1) + " " + r);
            } else if (max == r - i) {
                res.add((i + 1) + " " + r);
            }
            // tr("res", res);
            max = Math.max(max, r - i);
            ts.remove(new Pair(h[i], i));
            i++;
            while (ts.size() > 0 && ts.last().first - ts.first().first > k) {
                ts.remove(new Pair(h[i], i));
                i++;
            }
        }
        // tr("res", res);
        pr(max + " " + res.size());
        for (String e : res) pr(e);
    }

    class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if (first == o.first) return Integer.compare(second, o.second);
            return Integer.compare(first, o.first);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] h = fs.readArray(n);
        solve(n, k, h);
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
        new E6().run();
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