/**
 * 11/08/21 morning
 * https://leetcode-cn.com/problems/z3XKBp/
 */
package leetcodecn.meituan2021;

import java.util.*;
import java.io.*;

public class B3 {
    static PrintWriter pw;

    // Accepted --- 96ms 73.61%
    // 题解 https://leetcode-cn.com/problems/z3XKBp/solution/java-zhao-zuo-you-duan-dian-96ms-7361-by-w8p9/
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        String s = fs.next();
        char[] a = s.toCharArray();
        int left = -1, right = -1;
        boolean leftFindM = false, rightFindT = false;
        for (int i = 0; i < n; i++) {
            if (a[i] == 'M') leftFindM = true;
            if (leftFindM) {
                if (a[i] == 'T') {
                    left = i;
                    break;
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == 'T') rightFindT = true;
            if (rightFindT) {
                if (a[i] == 'M') {
                    right = i;
                    break;
                }
            }
        }
        pr(s.substring(left + 1, right));
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
        new B3().run();
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
