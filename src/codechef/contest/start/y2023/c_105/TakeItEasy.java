/**
 * 10/25/23 evening
 * https://www.codechef.com/START105C/problems/TIES
 */
package codechef.contest.start.y2023.c_105;

import java.util.*;
import java.io.*;

class TakeItEasy {
    static PrintWriter pw;

    // Accepted https://www.codechef.com/viewsolution/1027203522
    void solve(int n, int[] a) {
        long sum = 0;
        boolean hasEven = false, hasOdd = false;
        for (int x : a) {
            sum += x;
            if (x % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }
        }
        // tr(sum, n);
        if (sum % n != 0) {
            pr("No");
            return;
        }
        if (hasEven && hasOdd) {
            pr("No");
            return;
        }
        long v = sum / n;
        if (v % 2 == 0 && hasOdd) {
            pr("No");
            return;
        }
        if (v % 2 != 0 && hasEven) {
            pr("No");
            return;
        }
        pr("Yes");
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
        new TakeItEasy().run();
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


