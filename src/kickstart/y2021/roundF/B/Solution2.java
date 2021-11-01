// 09/20/21 evening
package kickstart.y2021.roundF.B;

import java.util.*;
import java.io.*;

public class Solution2 {

    static PrintWriter pw;

    private final int N = (int) 3e5;

    // Accepted  09/20/21 evening
    // reference: tmwilliamlin168
    void solve(int d, int n, int k, int[] h, List<List<Integer>> start, List<List<Integer>> end) {
        // tr(start.get(3));
        // tr(end);
        long res = 0, ss = 0;
        TreeSet<Pair> ts1 = new TreeSet<>(); // PQ also
        TreeSet<Pair> ts2 = new TreeSet<>();
//        ts1.add(new int[] {1, 2}); // cannot insert
//        pw.println(ts1);
        for (int i = 0; i < d; i++) {
            for (Object e : start.get(i)) {
                int x = (int) e;
                ts1.add(new Pair(h[x], x));
                ss += h[x];
                if (ts1.size() > k) {
                    ss -= ts1.first().first;
                    ts2.add(ts1.first());
                    ts1.remove(ts1.first());
                }
            }
//            tr(ts1);
//            tr(ts2);
            start.get(i).clear();
            res = Math.max(res, ss);
            for (Object e : end.get(i)) {
                int x = (int) e;
                Pair tmp = new Pair(h[x], x);
                if (ts2.contains(tmp)) {
                    ts2.remove(tmp);
                } else {
                    ts1.remove(tmp);
                    ss -= h[x];
                    if (ts2.size() > 0) {
                        ss += ts2.last().first;
                        ts1.add(ts2.last());
                        ts2.remove(ts2.last());
                    }
                }
            }
            end.get(i).clear();
        }
        pr(res);
    }


    class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair y) {
            if (first == y.first) return Integer.compare(second, y.second);
            return Integer.compare(first, y.first);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            int d = fs.nextInt();
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] hap = new int[n]; // happiness
            List<List<Integer>> start = initializeGraph(N);
            List<List<Integer>> end = initializeGraph(N);
            for (int i = 0; i < n; i++) {
                hap[i] = fs.nextInt();
                start.get(fs.nextInt() - 1).add(i);
                end.get(fs.nextInt() - 1).add(i);
            }
            solve(d, n, k, hap, start, end);
        }
    }

    List<List<Integer>> initializeGraph(int n) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
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
        new Solution2().run();
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

    void tr(TreeSet<Pair> ts) {
        int[][] show = new int[ts.size()][2];
        int i = 0;
        for (Pair p : ts) {
            show[i] = new int[]{p.first, p.second};
            i++;
        }
        pw.println(Arrays.deepToString(show));
    }
}