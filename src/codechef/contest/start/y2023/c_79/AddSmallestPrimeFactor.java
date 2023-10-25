/**
 * 03/01/23 morning
 * https://www.codechef.com/START79C/problems/PRIMEFACT
 */
package codechef.contest.start.y2023.c_79;

import java.util.*;
import java.io.*;

class AddSmallestPrimeFactor {
    static PrintWriter pw;

    // Accepted
    void solve(int x, int y) {
        int res = 0;
        while (x % 2 != 0) {
            TreeSet<Integer> f = findAllPrimeFactors(x);
            x += f.first();
            res++;
        }
        // tr(x, y);
        if (y % 2 != 0) y++;
        res += y - x >> 1;
        pr(res);
    }

    TreeSet<Integer> findAllPrimeFactors(int n) {
        TreeSet<Integer> res = new TreeSet();
        int c = 2;
        while (n > 1) {
            if (n % c == 0) {
                res.add(c);
                n /= c;
            } else {
                c++;
            }
        }
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
        new AddSmallestPrimeFactor().run();
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

