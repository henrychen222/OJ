/**
 * 06/04/22 night
 * https://www.spoj.com/problems/JULKA/
 */
package spoj.classical.page1;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

class P54_Julka {
    static PrintWriter pw;

    /*
      Klaudia + Natalia = sum
      Klaudia - Natalia = diff
     */
    // Accepted --- https://www.spoj.com/status/JULKA,henrychen222/
    void solve(BigInteger sum, BigInteger diff) {
        BigInteger Klaudia = sum.add(diff).divide(new BigInteger("2")), Natalia = sum.subtract(Klaudia);
        pr(Klaudia);
        pr(Natalia);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = 10;
        while (t-- > 0) {
            BigInteger sum = fs.nextBigInteger(), diff = fs.nextBigInteger();
            solve(sum, diff);
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
        new P54_Julka().run();
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

        BigInteger nextBigInteger() {
            return new BigInteger(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
