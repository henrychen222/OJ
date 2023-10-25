/**
 * 02/22/23 morning
 * https://www.codechef.com/START78C/problems/BITEQU
 */
package codechef.contest.start.y2023.c_78;

import java.util.*;
import java.io.*;

class BitwiseEquation {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/90546964
    /*
     reference: https://www.codechef.com/viewsolution/90290110
                https://discuss.codechef.com/t/bitequ-editorial/105323/2
     */
    void solve(long N) {
        long[] res;
        if (N == 0) {
            res = new long[]{1, 3, 4, 5};
        } else {
            res = new long[4];
            res[0] = 1;
            res[1] = 2;
            res[2] = 1L << 32;
            res[3] = N ^ res[2];
        }
        // tr(test(res, N));
        outputA(res);
    }

    /////////////////////////////////////////////////////
    /*
          0:   ((1 & 0) | 1) ^ 1 = 0  ---
               ((0 & 1) | 1) ^ 1 = 0  ---
               ((1 & 1) | 0) ^ 1 = 0
               ((0 & 1) | 0) ^ 0 = 0  ---
               ((1 & 0) | 0) ^ 0 = 0
               ((0 & 0) | 0) ^ 0 = 0

          1:   ((1 & 1) | 0) ^ 0 = 1
               ((0 & 1) | 1) ^ 0 = 1  ---
               ((1 & 0) | 1) ^ 0 = 1  ---
               ((0 & 1) | 0) ^ 1 = 1  ---
               ((1 & 0) | 0) ^ 1 = 1
               ((0 & 0) | 0) ^ 1 = 1
     */
    /*
     001
     100
     011
     010
     ---
     001
     */
    void solve1(long N) {
        tr(Integer.toBinaryString(1));
        String[] zero = {"1011", "0111", "1101", "0100", "1000", "0000"};
        String[] one = {"1100", "0110", "1010", "0101", "1001", "0001"};
//        String[] zero = {"1011", "0111", "0100"};
//        String[] one = {"0110", "1010", "0101"};
        String s = Long.toBinaryString(N);
        int n = s.length();
//        tr(N, n, s);
        int[][] d = new int[4][n];
        long[] res = new long[4];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < 4; i++) {
                int c = s.charAt(j);
                if (c == '0') {
//                    d[i][j] = zero[1].charAt(i) - '0';
//                    d[i][j] = zero[j % 3].charAt(i) - '0';
                    d[i][j] = zero[j % zero.length].charAt(i) - '0';
                } else {
                    // d[i][j] = one[1].charAt(i) - '0';
                    // d[i][j] = one[j % 3].charAt(i) - '0';
                    d[i][j] = one[j % one.length].charAt(i) - '0';
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            long v = 0;
            for (int j = 0; j < n; j++) {
                if (d[i][j] == 1) v += 1L << n - 1 - j;
            }
            res[i] = v;
        }
        tr("d", d);
        tr(res, test(res, N));
        outputA(res);
    }

    int randomPickIndex(String[] a) {
        return (int) (Math.random() * a.length);
    }

    void outputA(long[] a) {
        for (long e : a) pw.print(e + " ");
        pr("");
    }

    boolean test(long[] a, long n) {
        Set<Long> se = new HashSet<>();
        for (long x : a) se.add(x);
        long res = ((a[0] & a[1]) | a[2]) ^ a[3];
        tr(res, n, se.size(), a.length);
        return res == n && se.size() == a.length;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextLong();
            solve(n);
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
        new BitwiseEquation().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
