/**
 * 12/21/21 evening
 * https://adventofcode.com/2021/day/2#part2
 */
package advent_of_code.y2021.day2;

import java.util.*;
import java.io.*;

class B {

    static PrintWriter pw;

    void solve(List<String> a) {
        int n = a.size(), x = 0, y = 0, aim = 0;
        for (int i = 0; i < n; i += 2) {
            String s = a.get(i);
            int t = Integer.parseInt(a.get(i + 1));
            if (s.equals("forward")) {
                x += t;
                y += aim * t;
            } else if (s.equals("up")) {
                aim -= t;
            } else if (s.equals("down")) {
                aim += t;
            }
        }
        pr(x * y);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        List<String> l = new ArrayList<>();
        try {
            while (true) {
                l.add(fs.next());
            }
        } catch (NullPointerException e) {
        }
        solve(l);
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
        new B().run();
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
            for (int i = 0; i < n; i++) a[i] = nextInt();
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