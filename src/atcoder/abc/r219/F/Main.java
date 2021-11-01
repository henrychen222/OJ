/**
 * 09/18/21 morning
 * https://atcoder.jp/contests/abc219/tasks/abc219_f
 */
package atcoder.abc.r219.F;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    void solve(String s, long k) {
        if (k >= 4) {
            s = s.repeat(4);
        } else {
            s = s.repeat((int) k);
        }
        // tr(s);
        int n = s.length();
        Set<String> se = new HashSet<>();
        int x = 0, y = 0;
        se.add(x + " " + y);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                x--;
                String ke = x + " " + y;
                se.add(ke);
            } else if (c == 'R') {
                x++;
                String ke = x + " " + y;
                se.add(ke);
            } else if (c == 'U') {
                y--;
                String ke = x + " " + y;
                se.add(ke);
            } else if (c == 'D') {
                y++;
                String ke = x + " " + y;
                se.add(ke);
            }
            // tr(x, y);
        }
        // tr(se);
        pr(se.size());
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s = fs.next();
        long k = fs.nextLong();
        solve(s, k);
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
        new Main().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}