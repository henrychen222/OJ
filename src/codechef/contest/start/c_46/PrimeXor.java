/**
 * 07/06/22 noon
 * https://www.codechef.com/START46C/problems/PRIME_XOR
 */
package codechef.contest.start.c_46;

import java.util.*;
import java.io.*;

class PrimeXor {
    static PrintWriter pw;

    // Accepted
    // reference: https://www.youtube.com/watch?v=QJ41Q_mRjhA
    void solve(int x, int y) {
        int[] res = op1(x, y);
        if (res.length == 0) res = op2(x, y);
        if (res.length == 0) res = op3(x, y);
        Arrays.sort(res);
        outputA(res);
    }

    int[] op1(int x, int y) {
        int a = 2, b = 2 ^ x, c = b ^ y;
        int[] t = {a, b, c};
        for (int i = 0; i < 3; i++) t[i] %= 2;
        int zero = 0;
        for (int e : t) {
            if (e == 0) zero++;
        }
        return zero == 1 ? new int[]{2, Math.min(b, c), Math.max(b, c)} : new int[]{};
    }

    int[] op2(int x, int y) {
        int b = 2, a = b ^ x, c = b ^ y;
        int[] t = {a, b, c};
        for (int i = 0; i < 3; i++) t[i] %= 2;
        int zero = 0;
        for (int e : t) {
            if (e == 0) zero++;
        }
        return zero == 1 ? new int[]{a, b, c} : new int[]{};
    }

    int[] op3(int x, int y) {
        int c = 2, b = c ^ y, a = x ^ b;
        int[] t = {a, b, c};
        for (int i = 0; i < 3; i++) t[i] %= 2;
        int zero = 0;
        for (int e : t) {
            if (e == 0) zero++;
        }
        return zero == 1 ? new int[]{a, b, c} : new int[]{};
    }


    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
        }
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
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
        new PrimeXor().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
