/**
 * 10/16/21 morning
 * https://codingcompetitions.withgoogle.com/kickstart/round/00000000004362d6/00000000008b3771
 */
package kickstart.y2021.roundG.A;

import java.util.*;
import java.io.*;

public class Solution {

    static PrintWriter pw;

    // Accepted
    void solve(int n, long d, long c, long m, String s) {
        char[] a = s.toCharArray();
        Set<Integer> dset = new HashSet<>();
        Set<Integer> cset = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == 'C') {
                cset.add(i);
            } else {
                dset.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] == 'C') {
                if (c > 0) {
                    c--;
                    cset.remove(i);
                } else {
                    break;
                }
            } else {
                if (d > 0) {
                    d--;
                    c += m;
                    dset.remove(i);
                } else {
                    break;
                }
            }
            // tr("idx", i, "d", d, "c", c);
        }
        // tr(cset, dset);
        pr(dset.size() == 0 ? "YES" : "NO");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            int n = fs.nextInt();
            long d = fs.nextLong();
            long c = fs.nextLong();
            long m = fs.nextLong();
            String s = fs.next();
            solve(n, d, c, m, s);
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
        new Solution().run();
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