/**
 * 08/22/21 afternoon
 * https://www.codechef.com/COOK132B/problems/DIFSTR
 */
package codechef.contest.cook.b_132;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class DifferentString {

    static PrintWriter pw;

    // Accepted
    // reference: https://leetcode.com/problems/find-unique-binary-string/discuss/1418687/Detailed-Explanation-O(N)-Java-C%2B%2B-Python-short-concise-code-Cantor's-Diagonalization
    void solve(int n, String[] a) {
        String res = "";
        for (int i = 0; i < a.length; i++) res += a[i].charAt(i) == '0' ? '1' : '0';
        pr(res);
    }

    // TLE
//    void solve(int n, String[] a) {
//        TreeSet<BigInteger> ts = new TreeSet<>();
//        for (String s : a) {
//            BigInteger tmp = new BigInteger(s, 2);
//            ts.add(tmp);
//        }
//        // tr("treeset", ts);
//        BigInteger min = ts.first(), max = ts.last();
//        BigInteger one = BigInteger.ONE;
//        BigInteger start = min.add(one), end = max.subtract(one);
//        // tr(min, one, start, end, start.compareTo(end), start.compareTo(start), start.compareTo(start.subtract(one)));
//        for (BigInteger x = start; x.compareTo(end) <= 0; x = x.add(one)) {
//            String s = new BigInteger(x.toString(2)).toString();
//            // tr(x, s);
//            if (!ts.contains(x) && s.length() == n) {
//                pr(s);
//                return;
//            }
//        }
//        String res = new BigInteger(min.subtract(one).toString(2)).toString();
//        String res2 = new BigInteger(max.add(one).toString(2)).toString();
//        // tr(res, res2);
//        if (res.length() < n) {
//            pr(parseRepeat(res, n - res.length()));
//        } else if (res.length() == n) {
//            pr(res);
//        } else {
//            if (res2.length() < n) res2 = parseRepeat(res2, n - res2.length());
//            pr(res2);
//        }
//    }
//
//    String parseRepeat(String s, int t) {
//        String res = "";
//        for (int i = 1; i <= t; i++) {
//            res += '0';
//        }
//        res += s;
//        return res;
//    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.next();
            }
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
        new DifferentString().run();
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