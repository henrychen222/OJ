/**
 * 02/01/23 morning
 * https://www.codechef.com/START76C/problems/ZEROSTRING
 */
package codechef.contest.start.y2023.c_76;

import java.util.*;
import java.io.*;

class NotDivisible {
    static PrintWriter pw;

    // Accepted
    void solve(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a[i] = 1;
            } else {
                a[i] = 2;
            }
        }
        // tr(test(a));
        outputA(a);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    boolean test(int[] a) {
        tr("array", a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] sub = Arrays.copyOfRange(a, i, j + 1);
                if (sub.length <= 1) continue;
                int sum = Arrays.stream(sub).sum();
                // tr(sub, sum);
                if (sum % sub.length == 0) {
                    tr("wrong", sub, sum, sub.length);
                    return false;
                }
            }
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
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
        new NotDivisible().run();
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
