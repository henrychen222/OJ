/**
 * 11/05/21 afternoon
 * https://leetcode-cn.com/problems/BaR9fy/
 */
package leetcodecn.meituan2021;

import java.util.*;
import java.io.*;

public class A1 {
    static PrintWriter pw;

    // Accepted --- 76ms 99.64%
    // 题解 https://leetcode-cn.com/problems/BaR9fy/solution/java-zhi-jie-jie-76ms-faster-than-9964-b-wma2/
    void solve(String s) {
        int n = s.length();
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!Character.isLowerCase(c) && !Character.isUpperCase(c)) {
                if (i == 0 || !Character.isDigit(c)) {
                    pr("Wrong");
                    return;
                }
            } else {
                a++;
            }
            if (Character.isDigit(c)) b++;
        }
        if (a >= 1 && b >= 1) {
            pr("Accept");
        } else {
            pr("Wrong");
        }
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int cas = fs.nextInt();
        while (cas-- > 0) {
            String s = fs.next();
            solve(s);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new A1().run();
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
