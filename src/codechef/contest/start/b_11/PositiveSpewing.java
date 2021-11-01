/**
 * 09/15/21 morning
 * https://www.codechef.com/START11B/problems/POSSPEW
 */

package codechef.contest.start.b_11;

import java.util.*;
import java.io.*;

class PositiveSpewing {

    static PrintWriter pw;

    // Accepted
    void solve(int n, int k, int[] a) {
        // tr(n, k, a);
        long sum = 0;
        Set<Integer> se = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) se.add(i);
            sum += a[i];
        }
        // tr("set", se, "sum", sum);
        int round = 0;
        while (se.size() < n) {
            if (round == k) {
                pr(sum);
                return;
            }
            Set<Integer> tmp = new HashSet<>();
            for (int i : se) {
                if (a[i] > 0) {
                    // tr("idx", i, a[i]);
                    if (i == 0) {
                        a[i + 1]++;
                        a[n - 1]++;
                        tmp.add(i + 1);
                        tmp.add(n - 1);
                    } else if (i == n - 1) {
                        a[0]++;
                        a[i - 1]++;
                        tmp.add(0);
                        tmp.add(i - 1);
                    } else {
                        a[i - 1]++;
                        a[i + 1]++;
                        tmp.add(i - 1);
                        tmp.add(i + 1);
                    }
                    sum += 2;
                }
            }
            se.addAll(tmp);
            round++;
            // tr(a, "round", round, "sum", sum, "set", se);
        }
        long rest = (long) k - round;
        // int rest = k - round;  // fuck issue here
        // tr(rest, sum);
        long res = sum + rest * n * 2;
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, k, a);
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
        new PositiveSpewing().run();
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