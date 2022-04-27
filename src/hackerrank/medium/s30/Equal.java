/**
 * 02/18/22 evening
 * https://www.hackerrank.com/challenges/equal/problem
 */
package hackerrank.medium.s30;

import java.util.*;
import java.io.*;

public class Equal {
    static PrintWriter pw;

    void solve(int n, int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) addOneOrManyMap(m, x);
        tr(m);
        int pre = 0;
        long step = 0;
        for (int x : m.keySet()) {
            int diff = x - pre;
            tr(x, "diff", diff, "step", step);
            if (diff > 5) {
                step += diff / 5;
                diff %= 5;
            }
            if (diff == 4 || diff == 3) {
                step += 2;
            } else if (diff == 1 || diff == 2 || diff == 5) {
                step++;
            }
            tr("after", step);
            pre = x;
        }
        pr(step);
    }

    <T> void addOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.put(x, m.getOrDefault(x, 0) + cnt);
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
        new Equal().run();
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
