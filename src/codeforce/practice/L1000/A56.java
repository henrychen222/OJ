/**
 * 10/31/21 night
 * https://codeforces.com/problemset/problem/56/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A56 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/56/133870791
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        List<String> l = new ArrayList<>(Arrays.asList("ABSINTH", "BEER", "BRANDY", "CHAMPAGNE", "GIN", "RUM", "SAKE", "TEQUILA", "VODKA", "WHISKEY", "WINE"));
        // pw.println(l);
        int n = fs.nextInt();
        int cnt = 0;
        while (n-- > 0) {
            String s = fs.next();
            if (l.contains(s)) {
                cnt++;
            } else {
                char c = s.charAt(0);
                if (Character.isDigit(c)) {
                    int x = Integer.parseInt(s);
                    if (x < 18) cnt++;
                }
            }
        }
        pr(cnt);
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
        new A56().run();
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