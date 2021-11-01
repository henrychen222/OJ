/**
 * 09/15/21 morning  afternoon complete
 * https://www.codechef.com/START11B/problems/ATMQ
 */

package codechef.contest.start.b_11;

import java.util.*;
import java.io.*;

// reference: https://www.codechef.com/viewsolution/51111201
// Accepted --- 0.46sec https://www.codechef.com/viewsolution/51178578
// read: https://discuss.codechef.com/t/atmq-editorial/94481  Editorialist's Solution
class ATMQueue {

    static PrintWriter pw;

    TreeSet<Pair> ts = new TreeSet<>(); // smaller power first, tie, smaller idx
    int pos, n;
    int[] a;

    void solve() {
        clear();
        int[] res = new int[n];
        ts.add(new Pair(a[0], 0));
        for (int i = 1; i <= n; i++) {
            Pair p = ts.pollLast(); // max power first
            int idx = -p.second;
            res[idx] = i;
            add();
            add();
        }
        output(res);
    }

    void clear() {
        pos = 1;
        ts.clear();
    }

    void add() {
        if (pos == n) return;
        ts.add(new Pair(a[pos], -pos));
        pos++;
    }

    void output(int[] a) {
        for (int e : a) {
            pw.print(e + " ");
        }
        pr("");
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
        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            a = fs.readArray(n);
            solve();
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
        new ATMQueue().run();
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