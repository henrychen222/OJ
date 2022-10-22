/**
 * 06/22/22 morning
 * https://www.codechef.com/START44C/problems/DENSE
 */
package codechef.contest.start.c_44;

import java.util.*;
import java.io.*;

class DenseBracketSequence {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/67387522
    // reference: https://www.youtube.com/watch?v=lY_LzH9kVf8
    void solve(int n, char[] s) {
        int res = minRemoveToDenseParentheses(s);
        pr(res);
    }

    int minRemoveToDenseParentheses(char[] s) {
        int n = s.length, res = n;
        int[] L = new int[n], R = new int[n];
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                L[i]++;
            }
            if (i > 0) {
                L[i] += L[i - 1];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == ')') {
                R[i]++;
            }
            if (i < n - 1) {
                R[i] += R[i + 1];
            }
            res = Math.min(res, n - 2 * Math.min(L[i], R[i]));
        }
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char[] s = fs.next().toCharArray();
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
        new DenseBracketSequence().run();
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
