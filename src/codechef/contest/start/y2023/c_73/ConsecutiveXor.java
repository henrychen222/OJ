/**
 * 01/11/23 morning
 * https://www.codechef.com/START73C/problems/XOR2
 */
package codechef.contest.start.y2023.c_73;

import java.util.*;
import java.io.*;

class ConsecutiveXor {
    static PrintWriter pw;

    /*
     001
     010
     100
     */
    // Accepted --- https://www.codechef.com/viewsolution/85252092
    // reference: https://discuss.codechef.com/t/xor2-editorial/104812
    void solve(int n, int[] a) {
        /*
          a[0] ^ a[1] ^ ... a[n-1] = xor
          after one operation
          a[0] ^ a[1] ^ (a[i] ^ x) ^ (a[i+1] ^ x)... a[n-1] = xor ^ x ^ x = xor;

          xor won't change, keep the same
         */
        int xor = 0;
        for (int x : a) xor ^= x;
        if (n % 2 == 0) {
            pr(xor == 0 ? "YES" : "NO");
        } else {
            pr("YES");
        }
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
        new ConsecutiveXor().run();
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