/**
 * 03/19/22 night
 * https://codingcompetitions.withgoogle.com/kickstart/round/00000000008cb33e/00000000009e7997
 */
package kickstart.y2022.roundA.B;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter pw;

    // Accepted
    void solve(String s) {
        long sum = sum(s), cur = sum;
        while (cur % 9 != 0) cur++;
        long add = cur - sum;
        // tr(s, add);
        if (add == 0) { // no leading zero case
            pr(s.substring(0, 1) + '0' + s.substring(1));
            return;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) - '0' > add) {
                pr(s.substring(0, i) + add + s.substring(i));
                return;
            }
        }
        pr(s + add);
    }

    long sum(String s) {
        long sum = 0;
        for (int i = 0; i < s.length(); i++) sum += s.charAt(i) - '0';
        return sum;
    }

    // TLE  (AC Test Set 1)
    void solve1(BigInteger n) {
        // pr(new BigInteger("10").pow(123456));
        BigInteger nine = new BigInteger("9");
        BigInteger zero = new BigInteger("0");
        BigInteger first = n.add(nine.subtract(n.mod(nine)));
        // tr(n, first);
        for (BigInteger x = first; ; x = x.add(nine)) {
            if (ok(n, x) && x.mod(nine).compareTo(zero) == 0) {
                pr(x);
                return;
            }
        }
    }

    boolean ok(BigInteger n, BigInteger x) {
        String sn = n.toString(), s = x.toString();
        if (s.length() - sn.length() != 1) return false;
        for (int i = 0; i < s.length(); i++) {
            String removeOne = s.substring(0, i) + s.substring(i + 1);
            if (removeOne.equals(sn)) return true;
        }
        return false;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            // BigInteger n = fs.nextBigInteger();
            String n = fs.next();
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
        new Solution().run();
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

        BigInteger nextBigInteger() {
            return new BigInteger(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}