/**
 * 04/13/22 morning
 * https://www.codechef.com/START34C/problems/BINMIS
 */
package codechef.contest.start.c_34;

import java.util.*;
import java.io.*;

// Accepted --- https://www.codechef.com/viewsolution/62877612
class BinaryMismatch {
    static PrintWriter pw;

    /*
     find [L, R] cnt(0) - cnt(1) == total String cnt(1) - cnt(0)
     */
    void solve(int n, String s) {
        int[] a = new int[n];
        int zero = 0, one = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                a[i] = -1;
                zero++;
            } else {
                a[i] = 1;
                one++;
            }
        }
        int diff = one - zero;
        if (diff % 2 != 0) {
            pr("NO");
            return;
        }
//        tr(s, a);
//        tr(zero, one, diff);

        /*
        WA
        // https://www.codechef.com/viewsolution/62877215
        // https://www.codechef.com/viewsolution/62877259
        if (zero == one) {
            pr("YES");
            pr(1 + " " + n);
            return;
        }
        int expectSum = diff;
        subarraySumEqualKRange(a, expectSum);
         */
        /**
         * reference: https://discuss.codechef.com/t/binmis-editorial/100583
         */
        int curDiff = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                curDiff++;
            } else {
                curDiff--;
            }
            if (curDiff * 2 == diff) {
                pr("YES");
                pr(1 + " " + (i + 1));
                return;
            }
        }
    }

    void subarraySumEqualKRange(int[] a, int k) {
        Map<Long, Integer> m = new HashMap<>();
        m.put(0L, 0);
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            long lsum = sum - k;
            if (m.containsKey(lsum)) {
                int l = m.get(lsum);
                pr("YES");
                pr((l + 1) + " " + (i + 1));
                return;
            }
            m.put(sum, i);
        }
        pr("NO");
    }


    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            solve(n, s);
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
        new BinaryMismatch().run();
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
