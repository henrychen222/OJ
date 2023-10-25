/**
 * 01/18/23 morning
 * https://www.codechef.com/START74C/problems/BAB_I
 */
package codechef.contest.start.y2023.c_74;

import java.util.*;
import java.io.*;

class ChefAndBabla {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] a) {
        boolean hasZero = Arrays.stream(a).anyMatch(x -> x == 0);
        boolean allPos = Arrays.stream(a).allMatch(x -> x > 0);
        boolean allNeg = Arrays.stream(a).allMatch(x -> x < 0);
        if (hasZero) {
            pr(-1);
            return;
        }
        Arrays.sort(a);
        if (allPos) {
            pr(a[0] - 1);
            return;
        }
        if (allNeg) {
            pr(-(a[n - 1] + 1));
            return;
        }
        // tr(a);
        int res = -1;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] < 0 && a[i] > 0) {
                int x = -(a[i - 1] + 1), y = a[i] - 1;
                // tr(x, y);
                res = Math.min(x, y);
                break;
            }
        }
        pr(res);
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
        new ChefAndBabla().run();
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
