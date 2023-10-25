/**
 * 02/22/23 morning
 * https://www.codechef.com/START78C/problems/EVALMAS
 */
package codechef.contest.start.y2023.c_78;

import java.util.*;
import java.io.*;

// Accepted
class ValidExpression {
    static PrintWriter pw;

    /*
     *****...+++++...
     *****...-----...
     */
    void solve(int n, int x) {
        int l = 1 - n, r = n + 1;
        if (x < l || x > r) {
            pr(-1);
            return;
        }
        if (x > 1) {
            pr(repeat("*", n - (x - 1)) + repeat("+", x - 1));
        } else if (x < 1) {
            pr(repeat("*", n - (1 - x)) + repeat("-", 1 - x));
        } else {
            pr(repeat("*", n));
        }
    }

    String repeat(String c, int t) {
        String res = "";
        while (t-- > 0) res += c;
        return res;
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
        new ValidExpression().run();
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
